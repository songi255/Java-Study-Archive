package algorithm.samsungswexpert;
/*
승진이는 지금까지 총 G 판의 프리셀 게임을 했으며, 오늘은 D 판의 프리셀 게임을 했다. 프리셀 게임에서 승진이는 이기거나 지며, 비기는 등의 일은 일어나지 않는다.

승진이는 오늘 프리셀 게임을 끝나고 통계를 열어봤는데, 흥미롭게도 오늘 한 D판 중 정확히 PD 퍼센트의 게임을 이겼고, 지금까지 한 G판 중 정확히 PG 퍼센트의 게임을 이겼다. 둘 다 반올림 된 값이 아니고, 정확히 그 만큼의 게임을 이긴 것이다. 하지만 승진이는 사실 오늘, 그리고 지금까지 몇 판의 프리셀 게임을 했는지 기억이 나지 않는다. 즉 승진이는 D, G 값이 무엇인지 모른다. 승진이가 아는 것이 단 한 가지 있는데, 그것은 오늘 많아야 N 판의 게임을 했다는 것이다. 즉, D ≤ N이다.

적당한 D, G가 존재해서 승진이가 오늘 본 통계와 같은 결과가 나오게 할 수 있을까? 아니면 사실 그러한 D, G가 존재하지 않고 통계 계산기에 오류가 있는 것일까?

총 D / G 판. 많아야 D는 N판

[입력]

첫 번째 줄에 테스트 케이스의 수 TC가 주어진다. 이후 TC개의 테스트 케이스가 새 줄로 구분되어 주어진다. 각 테스트 케이스는 다음과 같이 구성되었다.
    ∙ 첫 번째 줄에 세 정수 N, PD, PG 가 주어진다. (0 ≤ PD, PG ≤ 100, 1 ≤ N ≤ 1015)


[출력]

각 테스트 케이스마다
    ∙ 위와 같은 결과가 가능하면 “Possible”, 아니면 “Broken” 을 출력하라.

입력
3
100 1 50
1000 81 83
10 10 100
sample_input.txt
출력
#1 Possible
#2 Possible
#3 Broken
 */

import java.util.Scanner;

public class FreeCellAnalyze {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int loop = scanner.nextInt();
        for (int i = 0; i < loop; i++) {
            int N = scanner.nextInt();
            int pD = scanner.nextInt();
            int pG = scanner.nextInt();

            boolean isBroken = false;

            if(pG == 0 && !(pD == 0)) {isBroken = true;}
            if(pG == 100 && !(pD == 100)) {isBroken = true;}
            if (!isBroken){
                boolean found = false;
                Outer : for (int D = 1; D <= N; D++) {
                    for (int j = 0; j <= D; j++) {
                        if ((double)j/D*100 == pD){
                            found = true;
                            break Outer;
                        }
                    }
                }
                if (!found) isBroken = true;
            }
            System.out.println("#" + (i+1) + " " + (isBroken?"Broken":"Possible"));
        }
        scanner.close();
    }
}

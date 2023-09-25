package algorithm.samsungswexpert;

/*
15번 팔씨름을 하여 8번 이상 이기는

둘은 지금까지 k번의 팔씨름을 진행했다. 이 결과는 길이가 k인 ‘o’ 또는 ‘x’로만 구성된 문자열 S

소정이는 앞으로 팔씨름을 15번째 경기까지 진행했을 때 자신이 점심값을 면제받을 가능성이 있는지 알고자 한다. 이를 대신해 주는 프로그램을 작성하라.

[입력]
첫 번째 줄에 테스트 케이스의 수 T가 주어진다.
각 테스트 케이스는 하나의 줄로 이루어진다. 각 줄에는 ‘o’ 또는 ‘x’로만 구성된 길이가 1 이상 15 이하인 문자열 S가 주어진다.

[출력]
각 테스트 케이스마다, 소정이가 점심값을 면제받을 가능성이 있다면 ‘YES’, 없다면 ‘NO’를 출력한다.

입력
3
oxoxoxoxoxoxoxo
x
xxxxxxxxxxxx
sample_input.txt
출력
#1 YES
#2 YES
#3 NO
 */

import java.util.Scanner;

public class ArmWrestling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int loop = scanner.nextInt();
        scanner.nextLine();
        for (int looping = 0; looping < loop; looping++) {
            String input = scanner.nextLine();
            int xCount = 0;
            int oCount = 0;
            boolean canWin = true;
            for (int i = 0; i < input.length(); i++) {
                if (input.charAt(i)=='o') oCount++; else xCount++;
                if(xCount >= 8) {canWin = false; break;}
            }
            System.out.println("#" + (looping + 1) + " " + (canWin?"YES":"NO"));
        }

        scanner.close();
    }
}

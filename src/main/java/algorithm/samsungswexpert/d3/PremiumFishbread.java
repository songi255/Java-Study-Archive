package algorithm.samsungswexpert.d3;

import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public class PremiumFishbread {
    static int N;
    static int M;
    static int K;
    static List<Integer> list = new Vector<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        for (int loop = 0; loop < T; loop++) {
            boolean canSell = true;
            int count = 0;
            N = scanner.nextInt(); // 사람 수
            M = scanner.nextInt(); // 만드는 데 걸리는 시간
            K = scanner.nextInt(); // M초만에 만드는 붕어빵 개수
            list.clear();
            //입력
            for (int i = 0; i < N; i++) {
                list.add(scanner.nextInt());
            }
            list.sort(Integer::compareTo);

            int sell = 0;
            int made = 0;
            for (int i = 0; i < list.size(); i++) {
                int time = list.get(i);
                sell++;
                made = (time / M) * K;
                if (sell > made){
                    canSell = false;
                    break;
                }
            }

            System.out.println("#" + (loop + 1) + " " + (canSell ? "Possible" : "Impossible"));
        }


        scanner.close();
    }
}

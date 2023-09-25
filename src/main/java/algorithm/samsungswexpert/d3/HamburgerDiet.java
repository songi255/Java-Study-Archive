package algorithm.samsungswexpert.d3;

import java.util.Scanner;

public class HamburgerDiet {
    static int N;
    static int L;
    static int[] scores;
    static int[] calories;
    static int max;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        for (int loop = 0; loop < T; loop++) {
            N = scanner.nextInt(); // 재료 수
            L = scanner.nextInt(); // 제한 칼로리
            scores = new int[N];
            calories = new int[N];
            max = 0;

            for (int i = 0; i < N; i++) {
                scores[i] = scanner.nextInt();
                calories[i] = scanner.nextInt();
            }

            dfs(0, 0, 0);

            System.out.println("#" + (loop + 1) + " " + max);
        }

        scanner.close();
    }

    public static void dfs(int sumScore, int sumCal, int from){
        if (!(sumCal > L || from == N)){
            for (int i = from; i < N; i++) {
                if (sumCal + calories[i] <= L){
                    max = Math.max(max, sumScore + scores[i]);
                    dfs(sumScore + scores[i], sumCal + calories[i], i + 1);
                }
            }
        }
    }
}

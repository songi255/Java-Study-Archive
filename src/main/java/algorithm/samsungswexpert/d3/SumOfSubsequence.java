package algorithm.samsungswexpert.d3;

import java.util.Scanner;

public class SumOfSubsequence {
    static int count = 0;
    static int N = 0;
    static int K = 0;
    static int[] arr;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int loop = 0; loop < T; loop++) {
            count = 0;
            N = scanner.nextInt();
            K = scanner.nextInt();
            arr = new int[N];

            //입력
            for (int i = 0; i < N; i++) {
                arr[i] = scanner.nextInt();
            }

            dfs(0, 0);

            System.out.println("#" + (loop+1) + " " + count);
        }
        scanner.close();
    }

    public static void dfs(int sum, int from){
        if (sum == K){
            count++;
        }else if (sum < K){
            for (int i = from; i < N; i++) {
                dfs(sum + arr[i], i + 1);
            }
        }
    }
}

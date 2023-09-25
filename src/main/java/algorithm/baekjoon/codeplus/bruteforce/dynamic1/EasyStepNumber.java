package algorithm.baekjoon.codeplus.bruteforce.dynamic1;
//https://www.acmicpc.net/problem/10844

import java.util.Scanner;

public class EasyStepNumber {
    static int[][] memo; // row로 끝나는 col 길이의 계단수 개수

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        memo = new int[10][N+1];

        calculate(N);

        int sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += memo[i][N] % 1000000000;
            sum %= 1000000000;
        }

        System.out.println(sum);
        scanner.close();
    }

    public static void calculate(int N){
        if (N == 1){
            for (int i = 1; i < 10; i++) {
                memo[i][N] = 1; // i로 끝나는 길이가 1인 수 = 0빼고 1이다.
            }
        }else{
            if (memo[1][N-1] == 0){ // 계산되지 않았다면
                calculate(N-1);
            }
            for (int i = 0; i < 9; i++) { // 9 제외
                memo[i][N] += memo[i+1][N-1] % 1000000000;
                memo[i][N] %= 1000000000;
            }
            for (int i = 1; i < 10; i++) { // 1 제외
                memo[i][N] += memo[i-1][N-1] % 1000000000;
                memo[i][N] %= 1000000000;
            }
        }
    }
}

package algorithm.baekjoon.codeplus.bruteforce.dynamic1;
//https://www.acmicpc.net/problem/2193

import java.util.Scanner;

public class PinaryNumber {
    static long[][] memo;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        memo = new long[2][N+1]; // 각 열은 0으로 끝나는 개수, 1로 끝나는 개수임.

        System.out.println(endWith0(N) + endWith1(N));
        scanner.close();
    }

    public static long endWith0(int N){
        if (memo[0][N] == 0 && memo[1][N] == 0){ // 계산이 안되었으면
            if (N == 1){
                memo[1][N] = 1;
            }else if(N == 2){
                memo[0][N] = 1;
            }else{
                memo[0][N] = endWith0(N-1) + endWith1(N-1);
                memo[1][N] = endWith0(N-1);
            }
        }
        return memo[0][N];
    }

    public static long endWith1(int N){
        if (memo[0][N] == 0 && memo[1][N] == 0){ // 계산이 안되었으면
            if (N == 1){
                memo[1][N] = 1;
            }else if(N == 2){
                memo[0][N] = 1;
            }else{
                memo[0][N] = endWith0(N-1) + endWith1(N-1);
                memo[1][N] = endWith0(N-1);
            }
        }
        return memo[1][N];
    }
}

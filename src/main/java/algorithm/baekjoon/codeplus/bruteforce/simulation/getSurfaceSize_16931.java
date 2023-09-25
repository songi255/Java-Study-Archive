package algorithm.baekjoon.codeplus.bruteforce.simulation;

import java.util.Scanner;

public class getSurfaceSize_16931 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int[][] board = new int[N][M];
        int s1 = N * M, s2 = 0, s3 = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                board[i][j] = scanner.nextInt();
            }
        }
        for (int i = 0; i < N; i++) {
            int max = 0;
            for (int j = 0; j < M; j++) {
                if (board[i][j] > max) max = board[i][j];
            }
            s2 += max;
        }
        for (int i = 0; i < M; i++) {
            int max = 0;
            for (int j = 0; j < N; j++) {
                if (board[j][i] > max) max = board[j][i];
            }
            s3 += max;
        }
        System.out.println((s1+s2+s3)*2);
        scanner.close();
    }
}

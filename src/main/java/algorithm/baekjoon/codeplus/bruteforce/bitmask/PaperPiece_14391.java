package algorithm.baekjoon.codeplus.bruteforce.bitmask;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PaperPiece_14391 {
    static int N;
    static int M;
    static int[][] board;
    static int result;
    static boolean[][] used;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        N = Integer.parseInt(inputs[0]);
        M = Integer.parseInt(inputs[1]);
        board = new int[N][M];
        used = new boolean[N][M];
        result = 0;
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = input.charAt(j)-'0';
            }
        }
        search(0, 0, 0);
        System.out.println(result);
        br.close();
    }

    public static void search(int sum, int iFrom, int jFrom){
        int jNext = jFrom + 1;
        int iNext = iFrom;
        if (jNext == M){
            jNext = 0;
            iNext++;
        }
        if (iFrom == N){
            result = sum > result ? sum : result;
        }else{
            if (!used[iFrom][jFrom]){ // 선택되지 않았다면
                //세로 탐색
                int value = 0;
                int limit = -1;
                for (int i = iFrom; i < N; i++) {
                    if (!used[i][jFrom]){
                        used[i][jFrom] = true;
                        value = value * 10 + board[i][jFrom];
                        search(sum + value, iNext, jNext);
                    }else{
                        limit = i;
                        break;
                    }
                    if (i == (N-1)){
                        limit = N;
                    }
                }
                for (int i = iFrom + 1; i < limit; i++) {
                    used[i][jFrom] = false;
                }
                //가로 탐색
                value = board[iFrom][jFrom];
                limit = -1;
                for (int j = jFrom + 1; j < M; j++) {
                    if (!used[iFrom][j]){
                        used[iFrom][j] = true;
                        value = value * 10 + board[iFrom][j];
                        search(sum + value, iNext, jNext);
                    }else{
                        limit = j;
                        break;
                    }
                    if (j == (M-1)){
                        limit = M;
                    }
                }
                if (limit == -1) limit = jFrom+1;
                for (int j = jFrom; j < limit; j++) {
                    used[iFrom][j] = false;
                }
            }else{ // 해당 칸이 선택됬다면
                search(sum, iNext, jNext);
            }
        }
    }
}

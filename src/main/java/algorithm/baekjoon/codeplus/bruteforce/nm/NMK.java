package algorithm.baekjoon.codeplus.bruteforce.nm;
//

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class NMK {
    static int N;
    static int M;
    static int K;
    static int[][] board;
    static int[][] visited;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");
        N = Integer.parseInt(inputs[0]);
        M = Integer.parseInt(inputs[1]);
        K = Integer.parseInt(inputs[2]);

        board = new int[N][M];
        visited = new int[N][M];

        for (int i = 0; i < N; i++) {
            String[] values = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(values[j]);
            }
        }

        findMax(K, 0, 0, 0);
        System.out.println(max);
        br.close();
    }

    static void findMax(int depth, final int sum, int lastSelectedRow, int lastSelectedCol){
        if (depth > 0){
            for (int i = lastSelectedRow; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (visited[i][j] == 0){ // 방문하지 않았다면
                        modVisit(i, j, 1); //1회 증가
                        findMax(depth-1, sum + board[i][j], i, j);
                        modVisit(i, j, -1); //1회 감소
                    }
                }
            }
        } else if(depth == 0){
            max = Math.max(max, sum);
        }
    }

    static void modVisit(int row, int col, int value){
        visited[row][col] += value;
        if (row>0) visited[row-1][col] += value;
        if (row<N-1) visited[row+1][col] += value;
        if (col>0) visited[row][col-1] += value;
        if (col<M-1) visited[row][col+1] += value;
    }
}

package algorithm.baekjoon.codeplus.bruteforce.recursive;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class LinkStart_15661 {
    static int N;
    static int[][] board;
    static int result;
    static boolean[] team;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        team = new boolean[N];
        result = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            String[] inputs = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(inputs[j]);
            }
        }

        for (int i = 1; i <= N>>1; i++) {
            search(i, 0);
        }

        System.out.println(result);
        br.close();
    }

    public static void search(int depth, int from){
        if (depth == 0){
            int v1 = 0 , v2 = 0;
            for (int i = 0; i < N - 1; i++) {
                for (int j = i; j < N; j++) {
                    if (team[i] == team[j]){
                        if (team[i]){
                            v1 += board[i][j] + board[j][i];
                        }else{
                            v2 += board[i][j] + board[j][i];
                        }
                    }
                }
            }
            int diff = Math.abs(v1 - v2);
            if (diff < result) result = diff;
        }else{
            for (int i = from; i < N; i++) {
                team[i] = true;
                search(depth - 1, i + 1);
                team[i] = false;
            }
        }
    }
}

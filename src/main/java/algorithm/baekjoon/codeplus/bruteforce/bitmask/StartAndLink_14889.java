package algorithm.baekjoon.codeplus.bruteforce.bitmask;

import sun.nio.cs.SingleByte;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class StartAndLink_14889 {
    static int N;
    static int[][] board;
    static int[] team1;
    static int[] team2;
    static int result;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        team1 = new int[N>>1];
        team2 = new int[N>>1];
        result = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            String[] inputs = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(inputs[j]);
            }
        }

        search(N>>1, 0);
        System.out.println(result);
        br.close();
    }

    public static void search(int depth, int from){
        if (depth == 0){
            int v1 = 0, v2 = 0, c1 = 0, c2 = 0;
            for (int i = 0; i < N; i++) {
                if (c1 >= team1.length || team1[c1] != i){
                    team2[c2++] = i;
                }else{
                    c1++;
                }
            }
            for (int i = 0; i < team1.length-1; i++) {
                for (int j = i + 1; j < team1.length; j++) {
                    v1 += board[team1[i]][team1[j]] + board[team1[j]][team1[i]];
                    v2 += board[team2[i]][team2[j]] + board[team2[j]][team2[i]];
                }
            }
            int diff = Math.abs(v1-v2);
            if (result > diff) result = diff;
        }else{
            int idx = (N>>1) - depth;
            for (int i = from; i < N; i++) {
                team1[idx] = i;
                search(depth-1, i+1);
            }
        }
    }

}

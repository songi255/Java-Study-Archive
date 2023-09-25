package algorithm.baekjoon.codeplus.bruteforce.recursive;
//https://www.acmicpc.net/problem/14889

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class StartLink {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int[][] synerge;
    static int[] team;

    public static void main(String[] args) throws Exception{
        N = Integer.parseInt(br.readLine());
        synerge = new int[N][N];
        team = new int[N/2]; //역순으로 넣는다.

        /* 조건
        N은 짝수
        S(ii)는 항상 0
        두 팀으로 나누는데(인원은 같음) 시너지 합 차이의 최솟값 리턴해야 함
        */

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                synerge[i][j] = Integer.parseInt(input[j]);
            }
        }

        sb.append(String.valueOf(minDiff(N/2, 0)));


        bw.write(sb.toString()); bw.flush(); bw.close(); br.close();
    }

    static int minDiff(int depth, int sum){
        int min = sum;
        if (depth > 0){
            //차례로 추가해보기
            for (int i = team[depth-1] + 1; i < N/2-depth+1; i++) {
                team[depth-1] = i;
                int synergeSum = 0;
                for (int j = depth; j < N/2; j++) {
                    synergeSum += synerge[i][team[j]] + synerge[team[j]][i];
                }
                min = Math.min(min, minDiff(depth-1, sum + synergeSum));
            }
        }else{
            min = 0;
        }
        return min + sum;
    }

}

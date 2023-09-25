package algorithm.baekjoon.codeplus.bruteforce.recursive;
//https://www.acmicpc.net/problem/14501

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Quit {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static int N; // 날짜
    static int[] T_arr; //상담소요시간(일) (퇴사날짜까지 끝내지 못하면 불가능한 것)
    static int[] P_arr; //완료시 금액

    public static void main(String[] args) throws Exception{
        N = Integer.parseInt(br.readLine());
        T_arr = new int[N];
        P_arr = new int[N];
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            T_arr[i] = Integer.parseInt(input[0]);
            P_arr[i] = Integer.parseInt(input[1]);
        }

        int max = call(0, 0);
        sb.append(String.valueOf(max));
        bw.write(sb.toString()); bw.flush(); bw.close(); br.close();
    }

    static int call(int from, int sum){
        int max = sum;
        for (int i = from; i < N; i++) {
            if (i + T_arr[i] <= N) // 기간 초과하지 않는다면
                max = Math.max(max, call(i + T_arr[i], sum + P_arr[i]));
        }
        return max;
    }
}

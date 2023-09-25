package algorithm.baekjoon.codeplus.bruteforce.dynamic1;
//https://www.acmicpc.net/problem/11727

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class TwoNTiling2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int[] memo;

    public static void main(String[] args) throws Exception{
        N = Integer.parseInt(br.readLine());
        memo = new int[N+2];
        memo[1] = 1;
        memo[2] = 3;

        sb.append(CountCase(N)%10007);
        bw.write(sb.toString()); bw.flush(); bw.close(); br.close();
    }

    public static int CountCase(int num){
        if (num > 2 && memo[num]==0)
            memo[num] = (CountCase(num-1) + CountCase(num-2)*2) % 10007;
        return memo[num];
    }
}

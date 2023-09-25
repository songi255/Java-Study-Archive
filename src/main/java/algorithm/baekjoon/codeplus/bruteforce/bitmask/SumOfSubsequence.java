package algorithm.baekjoon.codeplus.bruteforce.bitmask;
//https://www.acmicpc.net/problem/1182

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SumOfSubsequence {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception{
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int[] sequence = new int[N];
        int count = 0;
        int bitmax = ~0; // 모두 1

        bitmax = ~(bitmax << N);

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            sequence[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= bitmax; i++) {
            int sum = 0;
            for (int j = 0; j < N; j++) {
                if ( (i & (1<<j) ) > 0 ) sum += sequence[j];
            }
            if (sum == S) count++;
        }

        sb.append(count);

        bw.write(sb.toString()); bw.flush(); bw.close(); br.close();
    }
}

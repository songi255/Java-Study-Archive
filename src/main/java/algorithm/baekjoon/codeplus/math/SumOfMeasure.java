package algorithm.baekjoon.codeplus.math;
//

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class SumOfMeasure {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception{
        int T = Integer.parseInt(br.readLine());
        long[] arr = new long[1000001];

        for (int i = 1; i <= 1000000; i++) {
            for (int j = i; j <= 1000000; j+=i) { // 피제수
                arr[j] += i;
            }
        }
        for (int i = 1; i <= 1000000; i++) {
            arr[i] += arr[i-1];
        }

        for (int i = 0; i < T; i++) {
            sb.append( arr[ Integer.parseInt(br.readLine()) ] ).append('\n');
        }

        bw.write(sb.toString()); bw.flush(); bw.close(); br.close();
    }
}

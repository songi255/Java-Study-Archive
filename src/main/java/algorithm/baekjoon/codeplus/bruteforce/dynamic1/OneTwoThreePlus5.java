package algorithm.baekjoon.codeplus.bruteforce.dynamic1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class OneTwoThreePlus5 {
    static long[][] memo;
    static int max = 0;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        memo = new long[3][100001]; // row+1 로 끝나는 n이 되는 합
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            sb.append(calculate(n)).append('\n');
        }

        bw.write(sb.toString()); bw.flush(); bw.close(); br.close();
    }

    public static long calculate(int n){
        if (max < 3) {
            memo[0][1] = 1;
            memo[1][2] = 1;
            memo[0][3] = 1;
            memo[1][3] = 1;
            memo[2][3] = 1;
            max = 3;
        }
        for (int i = max + 1; i <= n; i++) { // n까지 계산
            memo[0][i] = memo[1][i-1] + memo[2][i-1];
            memo[1][i] = memo[0][i-2] + memo[2][i-2];
            memo[2][i] = memo[0][i-3] + memo[1][i-3];
            memo[0][i] %= 1000000009;
            memo[1][i] %= 1000000009;
            memo[2][i] %= 1000000009;
        }
        max = Math.max(max, n);

        return (memo[0][n] + memo[1][n] + memo[2][n]) % 1000000009;
    }
}

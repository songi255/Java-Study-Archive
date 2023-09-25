package algorithm.baekjoon.codeplus.bruteforce.dynamic1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SumOfSquare {
    static int N;
    static int[] cash;
    static{
        int max = (int)Math.sqrt(100000);
        cash = new int[max + 1];
        for (int i = 1; i <= max; i++) {
            cash[i] = i * i;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for (int i = 2; cash[i] <= N; i++) {
            while( (N % cash[i]) == 0){
                N /= cash[i];
            }
        }
        int count = 0;
        while(true){
            int max = (int)Math.sqrt(N);
            N -= cash[max];
            count++;
            if (N == 0) break;
        }

        System.out.println(count);
        br.close();
    }
}

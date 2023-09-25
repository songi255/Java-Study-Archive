package algorithm.baekjoon.codeplus.math;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class FindPrime2 {
    public static void main(String[] args) throws Exception{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        Scanner scanner = new Scanner(System.in);
        int M = scanner.nextInt();
        int N = scanner.nextInt();

        Outer : for (int i = M; i <= N; i++) {
            if (i != 1){
                int max = (int)Math.sqrt(i);
                for (int j = 2; j <= max; j++) {
                    if (i % j == 0) continue Outer;
                }
                sb.append(i).append('\n');
            }
        }

        bw.write(sb.toString()); bw.flush(); bw.close();
        scanner.close();
    }
}

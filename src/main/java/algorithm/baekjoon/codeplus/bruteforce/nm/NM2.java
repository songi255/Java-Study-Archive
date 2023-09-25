package algorithm.baekjoon.codeplus.bruteforce.nm;
//https://www.acmicpc.net/problem/15650

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Scanner;

// 역시 DFS를 살짝 변형하여 적용할 수 있다.
public class NM2 {
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int M;
    static int[] stack;

    public static void main(String[] args) throws Exception{
        Scanner scanner = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = scanner.nextInt();
        M = scanner.nextInt();
        stack = new int[N];

        pick(1, M);

        bw.write(sb.toString()); bw.flush(); bw.close();scanner.close();
    }
    public static void pick(int from, int M) {
        for (int i = from; i <= N - M + 1; i++) {
            stack[NM2.M - M] = i;
            if (M == 1) { // 마지막 원소이면
                for (int j = 0; j < NM2.M; j++) {
                    sb.append(stack[j]).append((j == NM2.M - 1 ? '\n' : ' '));
                }
            } else {
                pick(i + 1, M - 1);
            }
        }
    }
}



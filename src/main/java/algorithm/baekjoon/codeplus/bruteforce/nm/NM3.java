package algorithm.baekjoon.codeplus.bruteforce.nm;
//https://www.acmicpc.net/problem/15651

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.Stack;

public class NM3 {
    public static void main(String[] args) throws Exception{
        Scanner scanner = new Scanner(System.in);
        BufferedWriter br = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();

        int N = scanner.nextInt();
        int M = scanner.nextInt();

        pick(N, M, stack, sb);

        br.write(sb.toString()); br.flush(); br.close();
        scanner.close();
    }

    public static void pick(int N, int depth, Stack<Integer> stack, StringBuilder sb){
        if (depth == 0){
            for (int i = 0; i < stack.size() - 1; i++) {
                sb.append(stack.get(i)).append(' ');
            }sb.append(stack.get(stack.size()-1)).append('\n');
        }else{
            for (int i = 1; i <= N; i++) {
                stack.push(i);
                pick(N, depth-1, stack, sb);
                stack.pop();
            }
        }
    }
}

package algorithm.baekjoon.codeplus.bruteforce.nm;
//https://www.acmicpc.net/problem/15652

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.Stack;

public class NM4 {
    public static void main(String[] args) throws Exception{
        Scanner scanner = new Scanner(System.in);
        BufferedWriter br = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();

        int N = scanner.nextInt();
        int M = scanner.nextInt();

        pick(N, M, 1, stack, sb);

        br.write(sb.toString()); br.flush(); br.close();
        scanner.close();
    }

    public static void pick(int N, int depth, int min, Stack<Integer> stack, StringBuilder sb){
        if (depth == 0){
            for (int i = 0; i < stack.size() - 1; i++) {
                sb.append(stack.get(i)).append(' ');
            }sb.append(stack.get(stack.size()-1)).append('\n');
        }else{
            for (int i = min; i <= N; i++) {
                stack.push(i);
                pick(N, depth-1, i, stack, sb);
                stack.pop();
            }
        }
    }
}

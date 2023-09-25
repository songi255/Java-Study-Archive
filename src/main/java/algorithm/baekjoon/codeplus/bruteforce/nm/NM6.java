package algorithm.baekjoon.codeplus.bruteforce.nm;
//https://www.acmicpc.net/problem/15655

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class NM6 {
    public static void main(String[] args) throws Exception{
        Scanner scanner = new Scanner(System.in);
        BufferedWriter br = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        List<Integer> nums = new LinkedList<>();

        int N = scanner.nextInt();
        int M = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < N; i++) {
            nums.add(scanner.nextInt());
        }
        nums.sort(Integer::compareTo);

        pick(N, M, 0, nums, stack, sb);

        br.write(sb.toString()); br.flush(); br.close();
        scanner.close();
    }

    public static void pick(int N, int depth, int min, List<Integer> nums, Stack<Integer> stack, StringBuilder sb){
        if (depth == 0){
            for (int i = 0; i < stack.size() - 1; i++) {
                sb.append(stack.get(i)).append(' ');
            }sb.append(stack.get(stack.size()-1)).append('\n');
        }else{
            for (int i = min; i < N; i++) {
                stack.push(nums.remove(i));
                pick(N-1, depth-1, i, nums, stack, sb);
                nums.add(i, stack.pop());
            }
        }
    }
}

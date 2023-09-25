package algorithm.samsungswexpert.d3;

import java.util.Scanner;
import java.util.Stack;

public class LongestPath {
    static int max = 0;
    static int N = 0;
    static int M = 0;
    static Stack<Integer> stack = new Stack<>();
    static boolean[][] path;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        for (int loop = 0; loop < T; loop++) {
            max = 0;
            N = scanner.nextInt(); // 정점
            M = scanner.nextInt(); // 간선
            path = new boolean[N][N];
            for (int i = 0; i < M; i++) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                path[x-1][y-1] = true;
            }

            dfs();

            System.out.println("#" + (loop + 1) + " " + max);
        }
        scanner.close();
    }

    public static void dfs(){
        if (stack.isEmpty()){
            for (int i = 0; i < N; i++) {
                stack.push(i);
                dfs();
                stack.pop();
            }
        }else{
            boolean limit = true;
            for (int i = 0; i < N; i++) {
                if (!stack.contains(i) && (path[stack.peek()][i] || path[i][stack.peek()])){
                    limit = false;
                    stack.push(i);
                    dfs();
                    stack.pop();
                }
            }
            if (limit) max = Math.max(max, stack.size());
        }
    }
}

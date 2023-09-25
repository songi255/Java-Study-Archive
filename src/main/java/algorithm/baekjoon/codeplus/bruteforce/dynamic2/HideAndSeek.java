package algorithm.baekjoon.codeplus.bruteforce.dynamic2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class HideAndSeek {
    static int N;
    static int K;
    static Queue<Integer> queue1 = new LinkedList<>();
    static Queue<Integer> queue2 = new LinkedList<>();
    static int depth;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        K = scanner.nextInt();

        queue1.offer(N);
        bfs();

        System.out.println(depth);

        scanner.close();
    }

    static void bfs(){
        boolean found = false;
        depth++;
        while (!queue1.isEmpty()){
            int x = queue1.poll();
            if (x == K) { found = true; break; }
            queue2.offer(x-1);
            queue2.offer(x+1);
            queue2.offer(2*x);
        }
        queue1.addAll(queue2);
        queue2.clear();
        if(!found) bfs();
    }
}

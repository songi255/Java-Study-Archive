package algorithm.baekjoon.codeplus.bruteforce.queue_and_graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Queue_10845 {
    static int N;
    static Deque<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            String[] command = br.readLine().split(" ");
            Integer num = null;
            switch (command[0]){
                case "push"  : queue.offer(Integer.parseInt(command[1])); break;
                case "pop"   : num = queue.pollFirst(); sb.append( ( num == null) ? -1 : num).append('\n'); break;
                case "size"  : sb.append(queue.size()).append('\n'); break;
                case "empty" : sb.append( (queue.isEmpty()) ? 1 : 0 ).append('\n'); break;
                case "front" : num = queue.peekFirst(); sb.append( (num == null) ? -1 : num ).append('\n'); break;
                case "back" : num = queue.peekLast(); sb.append( (num == null) ? -1 : num ).append('\n'); break;
            }
        }
        System.out.println(sb);
        br.close();
    }
}

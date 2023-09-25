package algorithm.baekjoon.codeplus.bruteforce.queue_and_graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Deque_10866 {
    static int N;
    static Deque<Integer> deque = new LinkedList<>();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            String[] command = br.readLine().split(" ");
            Integer num = null;
            switch (command[0]){
                case "push_front"  : deque.addFirst(Integer.parseInt(command[1])); break;
                case "push_back"  : deque.addLast(Integer.parseInt(command[1])); break;
                case "pop_front"   : num = deque.pollFirst(); sb.append( ( num == null) ? -1 : num).append('\n'); break;
                case "pop_back"   : num = deque.pollLast(); sb.append( ( num == null) ? -1 : num).append('\n'); break;
                case "size"  : sb.append(deque.size()).append('\n'); break;
                case "empty" : sb.append( (deque.isEmpty()) ? 1 : 0 ).append('\n'); break;
                case "front" : num = deque.peekFirst(); sb.append( (num == null) ? -1 : num ).append('\n'); break;
                case "back" : num = deque.peekLast(); sb.append( (num == null) ? -1 : num ).append('\n'); break;
            }
        }
        System.out.println(sb);
        br.close();
    }
}

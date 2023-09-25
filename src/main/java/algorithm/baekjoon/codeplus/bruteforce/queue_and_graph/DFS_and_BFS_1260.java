package algorithm.baekjoon.codeplus.bruteforce.queue_and_graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class DFS_and_BFS_1260 {
    static int N;
    static int M;
    static int V;
    static boolean[] visited;
    static boolean[][] graph;
    static Queue<Integer> queue = new LinkedList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        N = Integer.parseInt(inputs[0]);
        M = Integer.parseInt(inputs[1]);
        V = Integer.parseInt(inputs[2]);
        visited = new boolean[N];
        graph = new boolean[N][N];
        for (int i = 0; i < M; i++) {
            inputs = br.readLine().split(" ");
            int from = Integer.parseInt(inputs[0]);
            int to = Integer.parseInt(inputs[1]);
            graph[from - 1][to - 1] = true;
        }

        dfs(V - 1);
        sb.trimToSize();
        sb.deleteCharAt(sb.capacity() - 1);
        sb.append('\n');

        sb.append(V).append(' ');
        Arrays.fill(visited, false);
        visited[V-1] = true;
        queue.offer(V - 1);
        bfs();
        sb.trimToSize();
        sb.deleteCharAt(sb.capacity() - 1);
        sb.append('\n');

        System.out.println(sb);
        br.close();
    }

    public static void dfs(int from){
        visited[from] = true;
        sb.append(from + 1).append(' ');
        for (int i = 0; i < N; i++) {
            if (!visited[i] && (graph[from][i] || graph[i][from])){
                dfs(i);
            }
        }
    }

    public static void bfs(){
        while(!queue.isEmpty()){
            int from = queue.poll();
            for (int i = 0; i < N; i++) {
                if (!visited[i] && (graph[from][i] || graph[i][from])){
                    visited[i] = true;
                    queue.offer(i);
                    sb.append(i + 1).append(' ');
                }
            }
        }
    }
}

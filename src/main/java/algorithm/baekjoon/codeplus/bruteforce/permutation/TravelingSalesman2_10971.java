package algorithm.baekjoon.codeplus.bruteforce.permutation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class TravelingSalesman2_10971 {
    static int N;
    static int[][] costs;
    static List<Integer> list = new LinkedList<>();
    static int prev;
    static int result;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        costs = new int[N][N];
        for (int i = 0; i < N; i++) {
            String[] inputs = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                costs[i][j] = Integer.parseInt(inputs[j]);
            }
        }
        for (int i = 1; i < N; i++) {
            list.add(i);
        }

        prev = 0;
        result = Integer.MAX_VALUE;
        search(N - 1, 0);

        System.out.println(result);
        br.close();
    }

    public static void search(int depth, int sum){
        if (depth == 0){
            int cost = costs[prev][0];
            if (cost != 0)
                if ((cost + sum) < result) result = cost + sum;
        }else{
            for (int i = 0; i < list.size(); i++) {
                int current = list.remove(i);
                int cost = costs[prev][current];
                if (cost != 0){
                    int temp = prev;
                    prev = current;
                    search(depth - 1, sum + cost);
                    prev = temp;
                }
                list.add(i, current);
            }
        }
    }
}

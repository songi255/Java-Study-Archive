package algorithm.baekjoon.shortTermGrow;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Domino_4196 {
    static int N;
    static int M;
    static int result;
    static List<Set<Integer>> list = new LinkedList<>();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            list.clear();

            for (int j = 0; j < M; j++) {
                st = new StringTokenizer(br.readLine());
                int head = Integer.parseInt(st.nextToken());
                int follow = Integer.parseInt(st.nextToken());
                boolean found = false;
                for (Set set : list) {
                    if (set.contains(head)){

                    }
                }

            }

            System.out.println(result);
        }
        br.close();
    }
}

package algorithm.baekjoon.codeplus.bruteforce.permutation;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class OperatorInsert_14888 {
    static int N;
    static int[] op;
    static int[] arr;
    static int max;
    static int min;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        op = new int[4];

        String[] inputs = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(inputs[i]);
        }
        inputs = br.readLine().split(" ");
        for (int i = 0; i < 4; i++) {
            op[i] = Integer.parseInt(inputs[i]);
        }
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;

        search(N - 1, arr[0]);
        System.out.println(max);
        System.out.println(min);
        br.close();
    }

    public static void search(int depth, int sum){
        if (depth == 0){
            if (sum > max) max = sum;
            if (sum < min) min = sum;
        }else{
            int idx = N - depth; // arr 기준.
            for (int i = 0; i < 4; i++) {
                if (op[i] > 0){
                    op[i]--;
                    switch (i){
                        case 0: search(depth - 1, sum + arr[idx]); break;
                        case 1: search(depth - 1, sum - arr[idx]); break;
                        case 2: search(depth - 1, sum * arr[idx]); break;
                        case 3: search(depth - 1, sum / arr[idx]); break;
                    }
                    op[i]++;
                }
            }
        }
    }
}

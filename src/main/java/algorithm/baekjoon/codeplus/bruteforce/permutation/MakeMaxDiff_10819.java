package algorithm.baekjoon.codeplus.bruteforce.permutation;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MakeMaxDiff_10819 {
    static int N;
    static int[] arr;
    static int[] temp;
    static boolean[] used;
    static int result;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        temp = new int[N];
        used = new boolean[N];

        String[] inputs = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(inputs[i]);
        }

        result = 0;
        search(N);

        System.out.println(result);
        br.close();
    }

    public static void search(int depth){
        if (depth == 0){
            int sum = 0;
            for (int i = 0; i < N - 1; i++) {
                sum += Math.abs(temp[i] - temp[i + 1]);
            }
            if (sum > result) result = sum;
        }else{
            int idx = N - depth;
            for (int i = 0; i < N; i++) {
                if (!used[i]){
                    temp[idx] = arr[i];
                    used[i] = true;
                    search(depth - 1);
                    used[i] = false;
                }
            }
        }
    }
}

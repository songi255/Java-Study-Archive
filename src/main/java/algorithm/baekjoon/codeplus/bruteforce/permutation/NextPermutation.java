package algorithm.baekjoon.codeplus.bruteforce.permutation;
//https://www.acmicpc.net/problem/10972

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class NextPermutation {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int[] arr;
    static int[] temp;
    static boolean[] used;
    static boolean found;
    static boolean initialized;

    public static void main(String[] args) throws Exception{
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        temp = new int[N];
        used = new boolean[N];

        String[] inputs = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(inputs[i]);
        }

        search(N);
        if (found){
            for (int i = 0; i < temp.length - 1; i++) {
                sb.append(temp[i]).append(' ');
            }sb.append(temp[temp.length - 1]).append('\n');
        }else{
            sb.append(-1).append('\n');
        }

        bw.write(sb.toString()); bw.flush(); bw.close(); br.close();
    }

    public static void search(int depth){
        if (depth == 0){
            if (!initialized){
                initialized = true;
            }else{
                found = true;
            }
        }else{
            int idx = N - depth;
            for (int i = 0; i < N; i++) {
                if (found) return;
                if (!initialized){
                    i = arr[idx] - 1;
                }
                if (!used[i]){
                    used[i] = true;
                    temp[idx] = i + 1;
                    search(depth - 1);
                    used[i] = false;
                }
            }
        }
    }
}

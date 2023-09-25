package algorithm.baekjoon.codeplus.bruteforce.dynamic1;
//https://www.acmicpc.net/problem/11052

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BuyCard2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int[] P_arr;

    public static void main(String[] args) throws Exception{
        N = Integer.parseInt(br.readLine());
        P_arr = new int[N];

        String[] inputs = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            P_arr[i] = Integer.parseInt(inputs[i]);
        }

        update();

        System.out.println(P_arr[N-1]);
        br.close();
    }

    public static void update(){ //각 가중치를 업데이트한다.
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < (i+1)/2; j++) {
                P_arr[i] = Math.min(P_arr[i], P_arr[j] + P_arr[i-1-j]);
            }
        }
    }
}

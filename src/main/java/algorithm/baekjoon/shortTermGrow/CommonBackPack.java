package algorithm.baekjoon.shortTermGrow;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class CommonBackPack {
    static int N;
    static int K;
    static int[] W;
    static int[] V;
    static int max = Integer.MIN_VALUE;
    static Stack<Integer> bag = new Stack<>();
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        N = Integer.parseInt(inputs[0]); // 물품 종류
        K = Integer.parseInt(inputs[1]); // 배낭 capacity
        W = new int[N];
        V = new int[N];
        for (int i = 0; i < N; i++) {
            inputs = br.readLine().split(" ");
            W[i] = Integer.parseInt(inputs[0]); // 무게
            V[i] = Integer.parseInt(inputs[1]); // 가치
        }
        for (int i = 0; i < N; i++) {
            bag.push(i);
        }

        bfs(0,0, 0);

        System.out.println(max);
        br.close();
    }

    public static boolean bfs(int wSum, int vSum, int last){
        boolean overflow = false;
        if (wSum > K){
            overflow = true;
        }else{
            boolean allOveflow = true;
            for (int i = last; i < bag.size(); i++) {
                int idx = bag.remove(i);
                if(!bfs(wSum + W[idx], vSum + V[i], i)){
                    allOveflow = false;
                };
                bag.add(idx, i);
            }
            if (allOveflow){
                max = Math.max(max, wSum);
            }
        }
        return overflow;
    }
}

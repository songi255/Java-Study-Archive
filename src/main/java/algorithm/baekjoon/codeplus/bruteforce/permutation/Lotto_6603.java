package algorithm.baekjoon.codeplus.bruteforce.permutation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Lotto_6603 {
    static int k;
    static StringBuilder sb = new StringBuilder();
    static int[] nums;
    static boolean[] used;
    static int[] temp = new int[6];

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true){
            String[] inputs = br.readLine().split(" ");
            k = Integer.parseInt(inputs[0]);
            if (k == 0){
                sb.trimToSize();
                sb.deleteCharAt(sb.capacity() - 1);
                break;
            }

            nums = new int[k];
            used = new boolean[k];
            for (int i = 0; i < k; i++) {
                nums[i] = Integer.parseInt(inputs[i + 1]);
            }
            search(6, 0);
            sb.append('\n');
        }

        bw.write(sb.toString()); bw.flush(); bw.close(); br.close();
    }

    public static void search(int depth, int from){
        if (depth == 0){
            for (int i = 0; i < 5; i++) {
                sb.append(temp[i]).append(' ');
            }sb.append(temp[5]).append('\n');
        }else{
            int idx = 6 - depth;
            if ((k - from) < depth) return; //가짓수가 작으면

            for (int i = from; i < k; i++) {
                if (!used[i]){
                    used[i] = true;
                    temp[idx] = nums[i];
                    search(depth - 1, i + 1);
                    used[i] = false;
                }
            }
        }
    }
}

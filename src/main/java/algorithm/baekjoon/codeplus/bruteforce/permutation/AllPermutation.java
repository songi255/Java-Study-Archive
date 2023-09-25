package algorithm.baekjoon.codeplus.bruteforce.permutation;
//

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class AllPermutation {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static Stack<Integer> resultStack = new Stack<>();
    static Stack<Integer> numberStack = new Stack<>();
    static int N;

    public static void main(String[] args) throws Exception{
        N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++) {
            numberStack.push(i);
        }
        dfs(N);

        bw.write(sb.toString()); bw.flush(); bw.close(); br.close();
    }

    public static void dfs(int depth){
        if (depth == 0){
            for (int i = 0; i < resultStack.size()-1; i++) {
                sb.append(resultStack.get(i)).append(' ');
            }sb.append(resultStack.get(resultStack.size()-1)).append('\n');
        }else{
            for (int i = 0; i < depth; i++) {
                resultStack.push(numberStack.remove(i));
                dfs(depth - 1);
                numberStack.add(i,resultStack.pop());
            }
        }
    }
}

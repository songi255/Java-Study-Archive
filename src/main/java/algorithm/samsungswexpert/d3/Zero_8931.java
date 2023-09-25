package algorithm.samsungswexpert.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Zero_8931 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        for (int loop = 1; loop <= T; loop++) {
            int K = Integer.parseInt(br.readLine());
            stack.clear();

            for (int i = 0; i < K; i++) {
                int input = Integer.parseInt(br.readLine());
                if (input == 0) stack.pop();
                else stack.push(input);
            }

            System.out.println("#" + loop + " " + stack.stream().reduce(Integer::sum).orElse(0));
        }

        br.close();
    }
}

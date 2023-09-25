package algorithm.samsungswexpert.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class CodingTournament1_8673 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();

        for (int loop = 1; loop <= T; loop++) {
            int K = Integer.parseInt(br.readLine());
            queue.clear();

            //입력
            int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int i = 0; i < inputs.length; i++) {
                queue.offer(inputs[i]);
            }

            int loose = 0;
            while(queue.size() != 1){
                int a = queue.poll();
                int b = queue.poll();
                if (a > b){
                    loose += a - b;
                    queue.offer(a);
                }else{
                    loose += b - a;
                    queue.offer(b);
                }
            }

            System.out.println("#" + loop + " " + loose);
        }

        br.close();
    }
}

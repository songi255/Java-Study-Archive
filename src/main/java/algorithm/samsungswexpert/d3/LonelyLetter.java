package algorithm.samsungswexpert.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class LonelyLetter {
    static PriorityQueue queue = new PriorityQueue();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int loop = 0; loop < T; loop++) {
            String input = br.readLine();
            StringBuilder sb = new StringBuilder();
            queue.clear();
            for (int i = 0; i < input.length(); i++) {
                char letter = input.charAt(i);
                if (queue.contains(letter)){
                    queue.remove(letter);
                }else{
                    queue.offer(letter);
                }
            }
            if (queue.isEmpty()){
                sb.append("Good");
            }else{
                while(!queue.isEmpty()){
                    sb.append(queue.poll());
                }
            }

            System.out.println("#" + (loop+1) + " " + sb);
        }


        br.close();
    }
}

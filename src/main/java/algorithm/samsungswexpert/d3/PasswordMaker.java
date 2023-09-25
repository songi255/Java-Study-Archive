package algorithm.samsungswexpert.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class PasswordMaker {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> queue = new LinkedList<>();
        
        for (int loop = 1; loop <= 10; loop++) {
            br.readLine();
            String[] inputs = br.readLine().split(" ");
            queue.clear();
            // 입력
            for (int i = 0; i < inputs.length; i++) {
                queue.offer(Integer.parseInt(inputs[i]));
            }
            Outer : while(true){
                for (int i = 1; i <= 5; i++) {
                    int num = queue.poll();
                    if (num - i <= 0){
                        queue.offer(0);
                        break Outer;
                    }else{
                        queue.offer(num - i);
                    }
                }
            }

            
            
            System.out.print("#" + loop + " ");
            for (int i = 0; i < 8; i++) {
                System.out.print(queue.poll() + " ");
            }
            System.out.println();
        }


        br.close();
    }
}

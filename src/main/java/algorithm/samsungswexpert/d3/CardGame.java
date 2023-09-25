package algorithm.samsungswexpert.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class CardGame {
    static Stack<Integer> stack1 = new Stack<>();
    static Stack<Integer> stack2 = new Stack<>();
    static int win = 0;
    static int lose = 0;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int loop = 0; loop < T; loop++) {
            win = 0;
            lose = 0;
            stack1.clear();
            stack2.clear();

            String[] inputs = br.readLine().split(" ");
            for (int i = 0; i < inputs.length; i++) {
                stack1.push(Integer.parseInt(inputs[i]));
            }
            for (int i = 1; i <= 18; i++) {
                if (!stack1.contains(i)) stack2.push(i);
            }

            search(0, 0);

            System.out.println("#" + (loop + 1) + " " + win + " " + lose);
        }
        br.close();
    }
    
    public static void search(int winScore, int loseScore){
        if (stack1.isEmpty()){
            if (winScore > loseScore) win++;
            else if(winScore < loseScore) lose++;
        }else{
            for (int i = 0; i < stack1.size(); i++) {
                Integer temp1 = stack1.remove(i);
                Integer temp2 = stack2.pop();

                if(temp1 > temp2){ search(winScore + temp1 + temp2, loseScore); }
                else{ search(winScore, loseScore + temp1 + temp2); }

                stack1.add(i, temp1);
                stack2.push(temp2);
            }
        }
    }
}

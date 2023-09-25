package algorithm.samsungswexpert.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Trust {
    static int N;
    static int bluePos;
    static int OrangePos;
    static int blueTime;
    static int OrangeTime;
    static int move;
    static int buttonNum;
    static int totalTime;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int loop = 0; loop < T; loop++) {
            String[] inputs = br.readLine().split(" ");
            N = Integer.parseInt(inputs[0]);
            int idx = 0;
            bluePos = 0;
            OrangePos = 0;
            blueTime = 0;
            OrangeTime = 0;
            move = 0;
            buttonNum = 0;
            totalTime = 0;

            for (int i = 0; i < N; i++) {
                idx = (i * 2) + 1;
                buttonNum = Integer.parseInt(inputs[idx+1]);
                if (inputs[idx].equals("B")){
                    move = Math.abs(bluePos - buttonNum) - blueTime;
                    if (move < 0) move = 0;
                    OrangeTime += move + 1;
                    totalTime += move + 1;
                    bluePos = buttonNum;
                    blueTime = 0;
                }else{
                    move = Math.abs(OrangePos - buttonNum) - OrangeTime;
                    if (move < 0) move = 0;
                    blueTime += move + 1;
                    totalTime += move + 1;
                    OrangePos = buttonNum;
                    OrangeTime = 0;
                }
            }

            System.out.println("#" + (loop+1) + " " + (totalTime-1) );
        }


        br.close();
    }
}

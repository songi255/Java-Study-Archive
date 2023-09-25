package algorithm.samsungswexpert.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SubscriberWar {
    static int N;
    static int A;
    static int B;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int loop = 1; loop <= T; loop++) {
            String[] input = br.readLine().split(" ");
            N = Integer.parseInt(input[0]);
            A = Integer.parseInt(input[1]);
            B = Integer.parseInt(input[2]);
            int min = N - A - B;
            if (min > 0){
                min = 0;
            }else if (min < 0){
                min *= -1;
            }

            System.out.println("#" + loop + " " + Math.min(A, B) + " " + min);
        }

        br.close();
    }
}

package algorithm.samsungswexpert.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BinaryPresentation {
    static int N;
    static int M;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int loop = 1; loop <= T; loop++) {
            String[] input = br.readLine().split(" ");
            N = Integer.parseInt(input[0]);
            M = Integer.parseInt(input[1]);
            boolean on = true;
            for (int i = 0; i < N; i++) {
                if ( (M & (1<<i) ) == 0 ){
                    on = false;
                    break;
                }
            }

            System.out.println("#" + loop + " " + (on?"ON":"OFF"));
        }

        br.close();
    }
}

package algorithm.samsungswexpert.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TwoBulb {
    static int A;
    static int B;
    static int C;
    static int D;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int loop = 0; loop < T; loop++) {
            String[] inputs = br.readLine().split(" ");
            A = Integer.parseInt(inputs[0]);
            B = Integer.parseInt(inputs[1]);
            C = Integer.parseInt(inputs[2]);
            D = Integer.parseInt(inputs[3]);

            int result = Math.min(B,D) - Math.max(A,C);
            if (result < 0) result = 0;

            System.out.println("#" + (loop + 1) + " " + result);
        }

        br.close();
    }
}

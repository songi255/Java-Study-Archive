package algorithm.samsungswexpert.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Gugudan {
    static int A;
    static int B;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int loop = 0; loop < T; loop++) {
            String[] inputs = br.readLine().split(" ");
            A = Integer.parseInt(inputs[0]);
            B = Integer.parseInt(inputs[1]);

            System.out.println("#" + (loop+1) + " " + ((A <= 9 && B <= 9) ? A*B : -1));
        }

        br.close();

    }
}

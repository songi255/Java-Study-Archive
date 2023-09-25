package algorithm.samsungswexpert.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MathStudy {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int diff = '1' - 1;
        int T = Integer.parseInt(br.readLine());
        for (int loop = 0; loop < T; loop++) {
            int result = 0;
            String[] inputs = br.readLine().split(" ");
            int N = Integer.parseInt(inputs[0]); // 진법
            String X = inputs[1];
            for (int i = 0; i < X.length(); i++) {
                result += X.charAt(i) - diff;
            }

            System.out.println("#" + (loop+1) + " " + (result%(N-1)));
        }

        br.close();
    }
}

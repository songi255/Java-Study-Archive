package algorithm.samsungswexpert.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MonsterHunting {
    static int D;
    static int L;
    static int N;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int loop = 0; loop < T; loop++) {
            String[] inputs = br.readLine().split(" ");
            int result;
            D = Integer.parseInt(inputs[0]);
            L = Integer.parseInt(inputs[1]);
            N = Integer.parseInt(inputs[2]);

            result = (D * N) + (D /100 * N * (N-1) * L / 2);

            System.out.println("#" + (loop+1) + " " + result);
        }
        br.close();
    }
}

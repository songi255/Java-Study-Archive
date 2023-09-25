package algorithm.samsungswexpert.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Harvest {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int loop = 0; loop < T; loop++) {
            int value = 0;
            int N = Integer.parseInt(br.readLine());
            int diff = '1' - 1;
            int middle = N / 2;

            for (int i = 0; i < N; i++) {
                String line = br.readLine();

                int count = N - 2 * Math.abs(middle - i);
                count /= 2;

                for (int j = middle - count; j <= middle + count; j++) {
                    value += line.charAt(j) - diff;
                }
            }

            System.out.println("#" + (loop + 1) + " " + value);
        }

        br.close();
    }
}

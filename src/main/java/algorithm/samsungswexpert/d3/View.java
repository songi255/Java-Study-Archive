package algorithm.samsungswexpert.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class View {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 10; i++) {
            int length = Integer.parseInt(br.readLine());
            int[] buildings = new int[length + 4];
            String[] inputs = br.readLine().split(" ");

            int count = 0;
            for (int j = 0; j < length; j++) {
                buildings[j + 2] = Integer.parseInt(inputs[j]);
            }

            for (int j = 0; j < length; j++) {
                int max = 0;
                for (int k = 0; k < 5; k++) {
                    if (k == 2) continue;
                    max = Math.max(max, buildings[j+k]);
                }
                if (buildings[j+2] > max) count += buildings[j+2] - max;
            }

            System.out.println("#" + (i+1) + " " + count);
        }
    }
}

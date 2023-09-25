package algorithm.samsungswexpert.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SpotMart {
    static int N;
    static int M;
    static int[] weights;
    static int result = -1;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        for (int loop = 0; loop < TC; loop++) {
            String[] inputs = br.readLine().split(" ");
            N = Integer.parseInt(inputs[0]);
            M = Integer.parseInt(inputs[1]);
            weights = new int[N];
            result = -1;

            weights = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            Arrays.sort(weights);

            for (int i = 1; i < N; i++) {
                int idx = Arrays.binarySearch(weights, M - weights[i]);
                idx = Math.min(idx, i-1);
                for (int j = 0; j <= idx ; j++) {
                    if (weights[i] + weights[j] <= M){
                        result = Math.max(result, weights[i] + weights[j]);
                    }
                }
            }

            System.out.println("#" + (loop + 1) + " " + result);
        }


        br.close();
    }
}

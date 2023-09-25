package algorithm.samsungswexpert.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class NormalNumber {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int loop = 0; loop < T; loop++) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int count = 0;
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            for (int i = 1; i < N-1; i++) {
                if(arr[i] > arr[i-1] && arr[i] < arr[i+1])
                    count++;
                if(arr[i] < arr[i-1] && arr[i] > arr[i+1])
                    count++;
            }

            System.out.println("#" + (loop+1) + " " + count);
        }


        br.close();

    }
}

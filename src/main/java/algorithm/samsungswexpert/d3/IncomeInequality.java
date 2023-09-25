package algorithm.samsungswexpert.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class IncomeInequality {
    static int N;
    static int sum;
    static double mean;
    static int[] arr;
    static int count;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int loop = 1; loop <= T; loop++) {
            sb.append('#').append(loop).append(' ');
            sum = 0;
            mean = 0;
            count = 0;

            N = Integer.parseInt(br.readLine());
            arr = new int[N];
            
            String[] inputs = br.readLine().split(" ");
            for (int i = 0; i < inputs.length; i++) {
                arr[i] = Integer.parseInt(inputs[i]);
                sum += arr[i];
            }
            mean = (double)sum / N;
            for (int i = 0; i < N; i++) {
                if (arr[i] <= mean){
                    count++;
                }
            }
            sb.append(count).append('\n');
        }
        System.out.println(sb);
        br.close();
    }
}

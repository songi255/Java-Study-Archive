package algorithm.samsungswexpert.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class NumberModify {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int loop = 0; loop < T; loop++) {

            char[] input = br.readLine().toCharArray();
            int max = Integer.parseInt(new String(input));
            int min = max;

            char temp;
            for (int i = 0; i < input.length - 1; i++) {
                for (int j = i+1; j < input.length; j++) {
                    temp = input[i];
                    input[i] = input[j];
                    input[j] = temp;

                    if(input[0] != '0'){
                        max = Math.max(max, Integer.parseInt(new String(input)));
                        min = Math.min(min, Integer.parseInt(new String(input)));
                    }

                    temp = input[i];
                    input[i] = input[j];
                    input[j] = temp;
                }
            }
            System.out.println("#" + (loop+1) + " " + min + " " + max);
        }

        br.close();
    }
}

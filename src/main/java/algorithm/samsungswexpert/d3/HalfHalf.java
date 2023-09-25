package algorithm.samsungswexpert.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class HalfHalf {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int loop = 0; loop < T; loop++) {
            char[] input = br.readLine().toCharArray();
            Arrays.sort(input);

            System.out.println("#" + (loop+1) + " " + ((input[1] != input[2] && input[0] == input[1] && input[2] == input[3]) ? "Yes" : "No"));
        }


        br.close();
    }
}

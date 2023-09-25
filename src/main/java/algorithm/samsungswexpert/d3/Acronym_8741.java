package algorithm.samsungswexpert.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Acronym_8741 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int loop = 1; loop <= T; loop++) {
            String[] input = br.readLine().toUpperCase().split(" ");
            System.out.println("#" + loop + " " + input[0].charAt(0) + input[1].charAt(0) + input[2].charAt(0));
        }


        br.close();
    }
}

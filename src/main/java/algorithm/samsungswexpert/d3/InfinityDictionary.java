package algorithm.samsungswexpert.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class InfinityDictionary {
    public static void main(String[] args) throws  Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int loop = 0; loop < T; loop++) {
            String P = br.readLine();
            String Q = br.readLine();
            P = P + 'a';

            System.out.println("#" + (loop+1) + " " + (!P.equals(Q) ? "Y" : "N"));
        }
        br.close();
    }
}

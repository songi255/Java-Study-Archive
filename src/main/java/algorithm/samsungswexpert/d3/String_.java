package algorithm.samsungswexpert.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class String_ {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int loop = 0; loop < 10; loop++) {
            int testCaseNum = Integer.parseInt(br.readLine());
            String des = br.readLine();
            String src = "_" + br.readLine() + "_";

            String[] result = src.split(des);

            System.out.println("#" + testCaseNum + " " + (result.length - 1) );
        }

        br.close();
    }
}

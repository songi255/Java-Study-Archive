package algorithm.samsungswexpert.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Sunday {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int loop = 0; loop < T; loop++) {
            int result = -1;

            switch (br.readLine()){
                case "SUN":
                    result = 7; break;
                case "MON":
                    result = 6; break;
                case "TUE":
                    result = 5; break;
                case "WED":
                    result = 4; break;
                case "THU":
                    result = 3; break;
                case "FRI":
                    result = 2; break;
                case "SAT":
                    result = 1; break;
            }

            System.out.println("#" + (loop + 1) + " " + result);
        }

        br.close();
    }
}

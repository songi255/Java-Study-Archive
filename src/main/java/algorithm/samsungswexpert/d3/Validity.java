package algorithm.samsungswexpert.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Validity {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int a;
        int b;
        boolean mmyy;
        boolean yymm;
        boolean amb;

        for (int loop = 1; loop <= T; loop++) {
            sb.append('#').append(loop).append(' ');
            mmyy = true;
            yymm = true;
            amb = false;

            String input = br.readLine();

            a = (input.charAt(0) - '0') * 10 + input.charAt(1) - '0';
            b = (input.charAt(2) - '0') * 10 + input.charAt(3) - '0';
            if (a > 12 || a == 0) mmyy = false;
            if (b > 12 || b == 0) yymm = false;
            if (mmyy && yymm) amb = true;

            sb.append((amb ? "AMBIGUOUS" : (mmyy ? "MMYY" : (yymm ? "YYMM" : "NA") ) )).append('\n');
        }
        System.out.println(sb);

        br.close();
    }
}

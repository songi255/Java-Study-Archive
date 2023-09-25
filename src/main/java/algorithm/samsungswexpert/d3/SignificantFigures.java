package algorithm.samsungswexpert.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SignificantFigures {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int loop = 0; loop < TC; loop++) {
            String input = br.readLine();
            int count = -1;
            sb.append('#').append(loop + 1).append(' ');

            boolean up = false;

            double a = Math.round(Double.parseDouble(input.substring(0, 3)) / 10);
            if (a >= 100) {
                up = true;
                a = Math.round(a / 10);
            }
            sb.append((int) (a / 10)).append('.').append((int) (a % 10)).append("*10^").append(input.length() - 1 + (up ? 1 : 0)).append('\n');
        }

        System.out.println(sb);
        br.close();
    }
}

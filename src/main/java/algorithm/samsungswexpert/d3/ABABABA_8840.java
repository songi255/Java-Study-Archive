package algorithm.samsungswexpert.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ABABABA_8840 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int loop = 1; loop <= T; loop++) {
            sb.append('#').append(loop).append(' ');
            long L = Integer.parseInt(br.readLine());
            long i = L>>1;
            sb.append(i*i).append('\n');
        }
        System.out.println(sb);

        br.close();
    }
}

package algorithm.samsungswexpert.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class WriteAndErase_8821 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int nums = 0;

        for (int loop = 1; loop <= T; loop++) {
            sb.append('#').append(loop).append(' ');
            nums = 0;
            char[] input = br.readLine().toCharArray();

            //입력
            for (int i = 0; i < input.length; i++) {
                int idx = input[i]-'0';
                nums ^= 1 << idx;
            }
            int count = 0;
            for (int i = 0; i < 10; i++) {
                if ((nums & (1<<i))>0)
                    count++;
            }
            sb.append(count).append('\n');
        }
        System.out.println(sb);

        br.close();
    }
}

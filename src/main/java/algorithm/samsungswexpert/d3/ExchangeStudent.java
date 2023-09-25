package algorithm.samsungswexpert.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ExchangeStudent {
    static boolean[] exists = new boolean[7];

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int loop = 0; loop < T; loop++) {
            int n = Integer.parseInt(br.readLine());
            String input = br.readLine();

            int classPerWeek = 0;

            for (int i = 0; i < 7; i++) {
                boolean exist = input.charAt(i*2) == '1';
                if (exist){
                    classPerWeek++;
                }
                exists[i] = exist;
            }

            int min = Integer.MAX_VALUE;

            for (int i = 0; i < 7; i++) {
                //1칸씩 땡기기
                boolean temp = exists[0];
                for (int j = 0; j < 6; j++) {
                    exists[j] = exists[j+1];
                }
                exists[6] = temp;

                if (!exists[0])
                    continue;

                int result = 0;
                int lastClassOfWeek = -1;

                //lastClassOfWeek 계산
                for (int j = 0; j < 7; j++) {
                    if (exists[j]){
                        lastClassOfWeek = j;
                    }
                }

                int share = n / classPerWeek;
                int remain = n % classPerWeek;

                if (remain != 0){
                    result += share * 7;
                    for (int j = 0; j < 7 && remain > 0; j++) {
                        if (exists[j]){
                            remain--;
                        }
                        result++;
                    }
                }else{
                    result += share * 7 - (6-lastClassOfWeek);
                }

                min = Math.min(result, min);
            }

            System.out.println("#" + (loop + 1) + " " + min);
        }

        br.close();
    }
}

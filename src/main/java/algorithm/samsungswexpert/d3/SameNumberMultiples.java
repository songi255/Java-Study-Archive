package algorithm.samsungswexpert.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SameNumberMultiples {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int loop = 0; loop < T; loop++) {
            String input = br.readLine();
            int[] numberCountSrc = new int[10];
            int[] numberCountDes = new int[10];
            int diff = '0';
            boolean possible = false;

            for (int i = 0; i < input.length(); i++) {
                numberCountSrc[input.charAt(i) - diff]++;
            }

            int n = 2;
            Outer : while (true){
                String des = String.valueOf((Integer.parseInt(input) * n++));
                Arrays.fill(numberCountDes, 0);

                if (des.length() > input.length()){
                    break;
                }else{
                    for (int i = 0; i < des.length(); i++) {
                        numberCountDes[des.charAt(i) - diff]++;
                    }
                    for (int i = 0; i < 10; i++) {
                        if (numberCountDes[i] != numberCountSrc[i]){
                            continue Outer;
                        }
                    }
                    possible = true;
                }
            }

            System.out.println("#" + (loop + 1) + " " + (possible ? "Possible" : "Impossible"));
        }

        br.close();
    }
}

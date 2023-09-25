package algorithm.samsungswexpert.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MaxReward {
    static char[] numbers;
    static int max;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int loop = 0; loop < T; loop++) {
            String[] inputs = br.readLine().split(" " );
            numbers = inputs[0].toCharArray();
            max = 0;

            search(Integer.parseInt(inputs[1]));

            System.out.println("#" + (loop + 1) + " " + max);
        }

        br.close();
    }
    
    public static void search(int depth){
        if (depth == 0){
            int num = Integer.parseInt(new String(numbers));
            max = Math.max(max, num);
        }else{
            for (int i = 0; i < numbers.length - 1; i++) {
                for (int j = i + 1; j < numbers.length; j++) {
                    char temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                    search(depth - 1);
                    temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                }
            }
        }
    }
}

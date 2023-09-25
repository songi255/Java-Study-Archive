package algorithm.baekjoon.codeplus.bruteforce.recursive;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Guess_1248 {
    static int n;
    static char[] sighs;
    static int[] nums;
    static int[] result;
    static int[] startPos;
    static boolean found;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        sighs = br.readLine().toCharArray();

        nums = new int[n];
        result = new int[n];
        startPos = new int[n];

        int sum = 0;
        for (int i = n; i > 0; i--) {
            startPos[n - i] = sum;
            sum += i;
        }

        found = false;
        search(n);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n - 1; i++) {
            sb.append(result[i]).append(' ');
        }sb.append(result[n-1]).append('\n');

        System.out.println(sb);
        br.close();
    }

    public static void search(int depth){
        if (found) return;
        if (depth == 0){
            found = true;
            for (int i = 0; i < nums.length; i++) {
                result[i] = nums[i];
            }
        }else{
            int count = n - depth + 1; // 현재 개수
            for (int i = -10; i <= 10; i++) {
                nums[depth - 1] = i;
                boolean test = true;
                int sum = 0;
                for (int j = 0; j < count; j++) {
                    sum += nums[n - count + j];
                    char sign = (sum > 0) ? '+' : ((sum < 0) ? '-' : '0');
                    if ( sign != sighs[startPos[depth-1] + j] ){
                        test = false;
                        break;
                    }
                }
                if (test) search(depth - 1);
            }
        }
    }
}

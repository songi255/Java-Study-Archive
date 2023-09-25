package algorithm.baekjoon.codeplus.bruteforce;

import java.util.Scanner;

public class NumberAppend_1748 {
    static long[] arr = new long[8];
    static String N;
    static long result;
    static {
        arr[0] = 9;
        for (int i = 0; i < 7; i++) {
            arr[i+1] = (int)Math.pow(10,i+1) * 9 * (i+2) + arr[i];
        }
    }

    public static void main(String[] args) throws Exception{
        Scanner scanner = new Scanner(System.in);
        N = scanner.next();
        result = 0;
        if (N.length() == 1){
            result = Integer.parseInt(N);
        }else{
            int factor = N.length();
            result = Integer.parseInt(N) - (int)Math.pow(10,N.length()-1)+1;
            result *= factor;
            result += arr[N.length()-2];
        }
        System.out.println(result);
        scanner.close();
    }
}

package algorithm.baekjoon.codeplus.math;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class FindPrime {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int count = 0;

        String[] inputs = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            if (isPrime(Integer.parseInt(inputs[i]))) count++;
        }

        System.out.println(count);

        br.close();
    }

    public static boolean isPrime(int n){
        int max = (int)Math.sqrt(n);
        boolean isPrime = true;
        if(n == 1){
            isPrime = false;
        }else {
            for (int i = 2; i <= max; i++) {
                if (n % i == -0) {
                    isPrime = false;
                    break;
                }
            }
        }
        return isPrime;
    }
}

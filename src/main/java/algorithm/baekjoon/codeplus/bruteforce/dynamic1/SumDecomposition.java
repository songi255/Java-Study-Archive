package algorithm.baekjoon.codeplus.bruteforce.dynamic1;

import java.util.Scanner;

public class SumDecomposition {
    static int N;
    static int K;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt(); // 0~N까지
        K = scanner.nextInt(); // K개를 뽑아서 합이 N이 되는 경우의 수
        int[] numerators = new int[K + N - 1];
        int[] denominators = new int[N];
        int maxDivisor = 2;

        long result = 1;

        //소인수분해
        for (int i = N; i > 0; i--) {
            int divided1 = K + N - i;
            int divided2 = i;
            int divisor = 2;

            while (divided1 != 1){
                if(divided1 % divisor == 0) { //나눠지면
                    numerators[divisor - 1]++;
                    divided1 /= divisor;
                }else divisor++;
            }

            divisor = 2;
            while (divided2 != 1){
                if(divided2 % divisor == 0){ //나눠지면
                    denominators[divisor-1]++;
                    divided2 /= divisor;
                }
                else divisor++;
            }
            maxDivisor = Math.max(maxDivisor, divisor);
        }

        for (int i = 0; i < N; i++) {
            numerators[i] -= denominators[i];
        }

        for (int i = K + N - 1 - 1; i > 0 ; i--) {
            if (numerators[i] != 0){
                result *= numerators[i] * (i+1);
                result %= 1000000000;
            }
        }

        System.out.println(result);
        scanner.close();
    }
}

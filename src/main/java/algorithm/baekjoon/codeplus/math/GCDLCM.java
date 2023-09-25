package algorithm.baekjoon.codeplus.math;
//유클리드 호제법!!!!!

import java.util.Scanner;

public class GCDLCM {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int M = scanner.nextInt();

        int GCD = GCM(N, M);
        int LCM = N * M / GCD;

        System.out.println(GCD);
        System.out.println(LCM);
        scanner.close();
    }

    public static int GCM(int a, int b){
        if (a%b == 0){
            return b;
        }
        return GCM(b, a%b);
    }
}

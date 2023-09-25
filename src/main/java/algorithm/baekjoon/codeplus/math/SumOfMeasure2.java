package algorithm.baekjoon.codeplus.math;

import java.util.Scanner;

public class SumOfMeasure2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        long sum = 0;
        for (int i = 1; i <= N; i++) {
            sum += (N/i) * i;
        }

        System.out.println(sum);
        scanner.close();
    }
}

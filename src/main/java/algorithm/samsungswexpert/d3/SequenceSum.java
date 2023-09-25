package algorithm.samsungswexpert.d3;

import java.util.Arrays;
import java.util.Scanner;

public class SequenceSum {
    static int N;
    static int count;
    static int[] hash = new int[1415];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 1415; i++) {
            hash[i] = i * (i+1) / 2;
        }

        int T = scanner.nextInt();
        for (int loop = 0; loop < T; loop++) {
            count = 0;

            N = scanner.nextInt();
            int max = Arrays.binarySearch(hash, N);
            if (max < 0){
                max *= -1;
                max-=2;
            }

            for (int i = 1; i <= max; i++) {
                if (i%2 == 0){
                    if (N % (N / i * 2 + 1) == 0) count++;
                }else{
                    if (N % i == 0) count++;
                }
            }

            System.out.println("#" + (loop+1) + " " + count);
        }
        scanner.close();
    }
}

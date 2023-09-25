package algorithm.samsungswexpert.d3;

import java.util.Scanner;

public class PowerPole {
    static int N;
    static int[] A = new int[1000];
    static int[] B = new int[1000];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int loop = 1; loop <= T; loop++) {
            N = scanner.nextInt();
            int count = 0;
            for (int i = 0; i < N; i++) {
                A[i] = scanner.nextInt();
                B[i] = scanner.nextInt();
                for (int j = 0; j < i; j++) {
                    if ( ( (A[i]-A[j]) * (B[i]-B[j]) ) < 0 ){
                        count++;
                    }
                }
            }

            System.out.println("#" + loop + " " + count);
        }

        scanner.close();
    }
}

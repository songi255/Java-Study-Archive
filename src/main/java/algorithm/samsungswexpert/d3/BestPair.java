package algorithm.samsungswexpert.d3;

import java.util.HashSet;
import java.util.Scanner;

public class BestPair {
    static int N;
    static HashSet<Integer> hashSet = new HashSet<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int i = 1; i <= 9; i++) {
            String seed = "";
            for (int j = i; j <= 9; j++) {
                seed += j;
                hashSet.add(Integer.parseInt(seed));
            }
        }

        for (int loop = 1; loop <= T; loop++) {
            N = scanner.nextInt();
            int max = -1;
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = scanner.nextInt();
            }
            for (int i = 0; i < N - 1; i++) {
                for (int j = i+1; j < N; j++) {
                    int mult = arr[i] * arr[j];
                    if (hashSet.contains(mult) && (mult > max)) max = mult;
                }
            }

            System.out.println("#" + loop + " " + max);
        }


        scanner.close();
    }
}

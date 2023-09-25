package algorithm.samsungswexpert;

import java.util.Arrays;
import java.util.Scanner;

public class KthSuffix_1256 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int loop = 1; loop <= T; loop++) {
            int k = scanner.nextInt();
            String input = scanner.next();
            int length = input.length();

            String[] suffixes = new String[length];

            for (int i = 0; i < length; i++) {
                suffixes[i] = input.substring(length-i-1,length);
            }
            Arrays.sort(suffixes);

            System.out.println("#" + loop + " " + suffixes[k-1]);
        }
        scanner.close();
    }
}

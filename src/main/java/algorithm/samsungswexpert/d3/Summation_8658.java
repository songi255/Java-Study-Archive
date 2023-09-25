package algorithm.samsungswexpert.d3;

import java.util.Arrays;
import java.util.Scanner;

public class Summation_8658 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        scanner.nextLine();
        for (int loop = 1; loop <= T; loop++) {
            int[] arr = new int[10];
            String[] input = scanner.nextLine().split(" ");

            for (int i = 0; i < input.length; i++) {
                for (int j = 0; j < input[i].length(); j++) {
                    arr[i] += input[i].charAt(j) - '0';
                }
            }
            Arrays.sort(arr);

            System.out.println("#" + loop + " " + arr[9] + " " + arr[0]);
        }

        scanner.close();
    }
}

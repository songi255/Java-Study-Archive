package algorithm.samsungswexpert.d3;

import java.util.Scanner;

public class Teamwork {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int loop = 0; loop < T; loop++) {
            int N = scanner.nextInt();

            System.out.println("#" + (loop + 1) + " " + N/3);
        }

        scanner.close();
    }
}

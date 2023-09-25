package algorithm.samsungswexpert.d3;

import java.util.Scanner;

public class MinimalismClock {
    static int theta;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int loop = 1; loop <= T; loop++) {
            theta = scanner.nextInt();

            System.out.println("#" + loop + " " + (theta/30) + " " + ( (theta%30) * 2 ));
        }


        scanner.close();
    }
}

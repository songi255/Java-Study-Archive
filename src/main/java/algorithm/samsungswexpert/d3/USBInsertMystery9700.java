package algorithm.samsungswexpert.d3;

import java.util.Scanner;

public class USBInsertMystery9700 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int loop = 1; loop <= T; loop++) {
            double p = scanner.nextDouble();
            double q = scanner.nextDouble();

            System.out.println("#" + loop + " " + ( ( ((1-p)*q) < ( p * (1-q) * q ) ) ? "YES":"NO") );
        }

        scanner.close();
    }
}

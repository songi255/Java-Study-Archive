package algorithm.samsungswexpert.d3;

import java.util.Scanner;

public class SnackDistribution {
    static int N;
    static int K;

    public static void main(String[] args) throws Exception{
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        for (int loop = 1; loop <= T; loop++) {
            N = scanner.nextInt();
            K = scanner.nextInt();
            System.out.println("#" + loop + " " + ((N%K)==0?0:1));
        }

        scanner.close();
    }
}

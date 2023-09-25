package algorithm.samsungswexpert;

import java.util.Scanner;

public class OneDimensionGarden {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();

        for (int i = 0; i < T; i++) {
            int N = scanner.nextInt();
            int D = scanner.nextInt();
            D = D * 2 + 1;
            System.out.println("#" + (i+1) + " " + ( (N/D) + (N%D == 0 ? 0 : 1) ));
        }

        scanner.close();
    }
}

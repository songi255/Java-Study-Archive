package algorithm.samsungswexpert.d3;

import java.util.Scanner;

public class Dictation9317 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int loop = 1; loop <= T; loop++) {
            int N = scanner.nextInt();
            char[] input1 = scanner.next().toCharArray();
            char[] input2 = scanner.next().toCharArray();
            int count = 0;

            for (int i = 0; i < N; i++) {
                if(input1[i] == input2[i]) count++;
            }

            System.out.println("#" + loop + " " + count);
        }

        scanner.close();
    }
}

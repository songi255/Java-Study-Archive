package algorithm.samsungswexpert.d3;

import java.util.Scanner;

public class AlphabetStudy9480 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int loop = 1; loop <= T; loop++) {
            int N = scanner.nextInt();
            int[] words = new int[N];
            int full = 0b11111111111111111111111111;
            int count = 0;

            for (int i = 0; i < N; i++) {
                String input = scanner.next();
                for (int j = 0; j < input.length(); j++) {
                    words[i] |= 1 << (input.charAt(j)-'a');
                }
            }

            int max = (int)Math.pow(2, N) - 1;
            for (int i = 1; i <= max; i++) {
                int mask = 0;
                for (int j = 0; j < N; j++) {
                    if ((i&(1<<j)) > 0){
                        mask |= words[j];
                    }
                }
                if (mask == full){
                    count++;
                }
            }

            System.out.println("#" + loop + " " + count);
        }
        scanner.close();
    }
}

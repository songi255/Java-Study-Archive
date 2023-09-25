package algorithm.samsungswexpert.d3;

import java.util.Scanner;

public class MemoryRestore {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        for (int loop = 0; loop < T; loop++) {
            String memory = scanner.next();
            int count = 0;
            int last = '0';
            for (int i = 0; i < memory.length(); i++) {
                if (last != memory.charAt(i)){
                    count++;
                }
                last = memory.charAt(i);
            }

            System.out.println("#" + (loop + 1) + " " + count);
        }


        scanner.close();
    }
}

package algorithm.samsungswexpert.d3;

import java.util.Scanner;
import java.util.TreeSet;

public class Gugudan1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                treeSet.add(i*j);
            }
        }

        for (int loop = 0; loop < T; loop++) {
            int N = scanner.nextInt();

            System.out.println("#" + (loop+1) + " " + (treeSet.contains(N) ? "Yes" : "No"));
        }


        scanner.close();
    }
}

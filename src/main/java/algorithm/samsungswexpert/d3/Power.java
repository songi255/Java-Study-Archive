package algorithm.samsungswexpert.d3;

import java.util.Scanner;

public class Power {
    static int a;
    static int b;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        for (int loop = 0; loop < 10; loop++) {
            int testCaseNum = scanner.nextInt();
            a = scanner.nextInt();
            b = scanner.nextInt();

            System.out.println("#" + testCaseNum + " " + power(a, b));
        }

        scanner.close();
    }

    public static int power(int a, int b){
        if (b == 0){
            return 1;
        }else{
            return a * power(a, b-1);
        }
    }
}

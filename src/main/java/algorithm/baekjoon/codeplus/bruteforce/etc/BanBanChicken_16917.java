package algorithm.baekjoon.codeplus.bruteforce.etc;

import java.util.Scanner;

public class BanBanChicken_16917 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int A = scanner.nextInt();
        int B = scanner.nextInt();
        int C = scanner.nextInt();
        int X = scanner.nextInt();
        int Y = scanner.nextInt();
        int result = 0;
        if ((C+C) < A + B){
            int min = Math.min(X, Y);
            result += (C + C) * min;
            X -= min;
            Y -= min;
        }
        if( (C + C) < A){
            result += (C + C) * X;
            X = 0;
        }
        if( (C + C) < B){
            result += (C + C) * Y;
            Y = 0;
        }
        result += A * X + B * Y;
        System.out.println(result);
        scanner.close();
    }
}

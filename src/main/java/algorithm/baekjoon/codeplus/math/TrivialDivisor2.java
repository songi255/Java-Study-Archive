package algorithm.baekjoon.codeplus.math;
//https://www.acmicpc.net/problem/17427

import java.util.Scanner;

public class TrivialDivisor2 {
    public static void main(String[] args) throws Exception{
        Scanner scanner = new Scanner(System.in);

        int input = scanner.nextInt();
        int sum = 0;
        for (int i = 1; i <= input; i++) {
            sum += f(i);
        }
        System.out.println(sum);

        scanner.close();
    }

    public static int f(int n){
        int max = (int) Math.sqrt(n);
        int sum = 0;
        for (int i = 1; i <= max; i++) {
            if(n%i == 0){
                sum += i + n/i - (i==n/i ? i : 0);
            }
        }
        return sum;
    }
}

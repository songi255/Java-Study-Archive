package algorithm.baekjoon.codeplus.math;
//https://www.acmicpc.net/problem/10430

import java.util.Scanner;

public class One {
    public static void main(String[] args) throws Exception{
        Scanner scanner = new Scanner(System.in);

        while(true){
            int n = 0;
            try { n = scanner.nextInt();}
                catch (Exception e) { break; }
            int i = 1;
            int base = 1;
            while(true){
                base %= n;
                if (base == 0){ // 찾았으면
                    break;
                }else{
                    base = base * 10 + 1;
                    i++;
                }
            }
            System.out.println(i);
        }
    }
}

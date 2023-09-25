package algorithm.baekjoon.codeplus.bruteforce.dynamic1;
//https://www.acmicpc.net/problem/1463

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MakeIt1_1463 {
    static int N;
    static int result;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        result = N - 1;
        search(N, 0);

        System.out.println(result);
        br.close();
    }

    public static void search(int num, int count){
        if (num == 1){
            result = count < result ? count : result;
        }else if (num > 1){
            if (num % 2 == 0) search(num / 2, count + 1);
            if (num % 3 == 0) search(num / 3, count + 1);
            count++;
            num--;
            if (num % 2 == 0) search(num / 2, count + 1);
            if (num % 3 == 0) search(num / 3, count + 1);
            count++;
            num--;
            if (num % 2 == 0) search(num / 2, count + 1);
            if (num % 3 == 0) search(num / 3, count + 1);
        }
    }
}

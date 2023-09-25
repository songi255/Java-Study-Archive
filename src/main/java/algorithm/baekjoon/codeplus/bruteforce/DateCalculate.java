package algorithm.baekjoon.codeplus.bruteforce;
//https://www.acmicpc.net/problem/1476

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class DateCalculate {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] inputs = br.readLine().split(" ");

        // 1 ≤ E ≤ 15, 1 ≤ S ≤ 28, 1 ≤ M ≤ 19
        // E S M 을 년도로 환산하기.

        int E = Integer.parseInt(inputs[0]) - 1; // 계산편의를 위한 -1
        int S = Integer.parseInt(inputs[1]) - 1;
        int M = Integer.parseInt(inputs[2]) - 1;

        int i = 0;
        while(true){
            if((i%15 == E) && (i%28 == S) && (i%19 == M)) break;
            else i++;
        }
        System.out.println(i+1);

        bw.write(new char[0]); bw.flush(); bw.close(); br.close();
    }
}

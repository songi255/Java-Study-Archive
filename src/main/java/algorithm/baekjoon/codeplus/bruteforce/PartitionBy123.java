package algorithm.baekjoon.codeplus.bruteforce;
//https://www.acmicpc.net/problem/9095

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class PartitionBy123 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int loop = Integer.parseInt(br.readLine());
        for (int i = 0; i < loop; i++) {
            int N = Integer.parseInt(br.readLine());
            //sb.append(getPartition(N, 3)).append('\n');
            sb.append(getPartition(N)).append('\n');
        }

        bw.write(sb.toString()); bw.flush(); bw.close(); br.close();
    }


    public static int getPartition(int N){ // 숫자, 최대수, 현재 호출단계
        int sum = 0;

        if (N == 0){
            sum = 1;
        }else if(N > 0){
            sum += getPartition(N-3)+ getPartition(N-2) + getPartition(N-1);
        }
        return sum;
    }

    // 이건 조합에 중복없게 계산한 것...
    /*
    public static int getPartition(int N, int k){ // 숫자, 최대수, 현재 호출단계
        int sum = 0;

        if (N == 0){
            sum = 1;
        }else if(N > 0){
            switch (k){
                case 3: sum += getPartition(N-3, 3);
                case 2: sum += getPartition(N-2, 2);
                case 1: sum += getPartition(N-1, 1);
            }
        }
        System.out.printf("%d,%d : %d\n", N, k, sum);
        return sum;
    }*/
}

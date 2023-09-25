package algorithm.baekjoon.codeplus.bruteforce.etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SumOfNums2_2003 {
    static int N;
    static int M;
    static int[] arr;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        N = Integer.parseInt(inputs[0]);
        M = Integer.parseInt(inputs[1]);
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        long sum = 0;
        long result = 0;
        int start = 0, end = 0;
        boolean newExp = true;

        while(start < N && end < N){
            if (sum < M){
                sum += arr[end++];
            }else if (sum > M){
                if (newExp){
                    newExp = false;
                    while(sum > M){
                        sum -= arr[--end];
                    }
                }else{
                    sum -= arr[start++];
                    newExp = true;
                }
            }else{ // 같으면
                result++;
                sum -= arr[start++];
                newExp = true;
            }
        }
        if (sum == M) result++;

        System.out.println(result);
        br.close();
    }
}

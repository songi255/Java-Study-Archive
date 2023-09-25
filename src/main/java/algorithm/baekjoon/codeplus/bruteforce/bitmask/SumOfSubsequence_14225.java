package algorithm.baekjoon.codeplus.bruteforce.bitmask;

import java.util.Scanner;
import java.util.TreeSet;

public class SumOfSubsequence_14225 {
    public static void main(String[] args) {
        TreeSet<Long> treeset = new TreeSet<Long>();
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();
        }

        int max = (int)Math.pow(2, N);
        for (int i = 0; i < max; i++) {
            long sum = 0;
            for (int j = 0; j < N; j++) {
                int mask = 1<<j;
                if ((i & mask) > 0){
                    sum += arr[j];
                }
            }
            treeset.add(sum);
        }

        long result = treeset.first();
        while(true){
            if (result == treeset.last()){
                result = result + 1;
                break;
            }
            long current = treeset.higher(result);
            if ( (current - result) != 1 ){
                result = result + 1;
                break;
            }else{
                result = current;
            }
        }

        System.out.println(result);
        scanner.close();
    }
}

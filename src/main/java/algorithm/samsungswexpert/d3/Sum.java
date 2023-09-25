package algorithm.samsungswexpert.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Sum {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] rowSum = new int[100];
        int[] colSum = new int[100];

        for (int loop = 0; loop < 10; loop++) {
            int testCaseNum = Integer.parseInt(br.readLine());
            int max = 0;
            int diagonalSum1 = 0;
            int diagonalSum2 = 0;
            int temp = 0;
            Arrays.fill(rowSum, 0);
            Arrays.fill(colSum, 0);

            for (int i = 0; i < 100; i++) {
                String[] inputs = br.readLine().split(" ");
                for (int j = 0; j < 100; j++) {
                    temp = Integer.parseInt(inputs[j]);
                    rowSum[i] += temp;
                    colSum[j] += temp;
                    if (i + j == 99) diagonalSum1 += temp;
                    if (i == j) diagonalSum2 += temp;
                }
            }
            max = Math.max(max, diagonalSum1);
            max = Math.max(max, diagonalSum2);
            for (int i = 0; i < 100; i++) {
                max = Math.max(max, rowSum[i]);
                max = Math.max(max, colSum[i]);
            }

            System.out.println("#" + testCaseNum + " " + max);
        }

        br.close();
    }
}

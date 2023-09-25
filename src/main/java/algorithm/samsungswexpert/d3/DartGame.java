package algorithm.samsungswexpert.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class DartGame {
    static int N;
    static int x;
    static int y;
    static int distance;
    static int score;
    static int[] square = new int[10];
    static int idx;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        //계산값 초기화
        for (int i = 0; i < 10; i++) {
            square[i] = ((i+1) * 20);
            square[i] *= square[i];
        }


        for (int loop = 0; loop < TC; loop++) {
            score = 0;

            N = Integer.parseInt(br.readLine());
            for (int i = 0; i < N; i++) {
                String[] inputs = br.readLine().split(" ");
                x = Integer.parseInt(inputs[0]);
                y = Integer.parseInt(inputs[1]);
                distance = (x*x) + (y*y);

                idx = Arrays.binarySearch(square, distance);
                if (idx < 0) idx = (idx + 1) * -1;

                score += 10 - idx;
            }

            System.out.println("#" + (loop + 1) + " " + score);
        }

        br.close();
    }
}

package algorithm.samsungswexpert.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Magnet {
    static int N;
    static int count;
    static int[][] board = new int[100][100];


    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int loop = 0; loop < 10; loop++) {
            N = Integer.parseInt(br.readLine());
            count = 0;

            //입력
            for (int i = 0; i < 100; i++) {
                String[] inputs = br.readLine().split(" ");
                for (int j = 0; j < 100; j++) {
                    board[i][j] = Integer.parseInt(inputs[j]);
                }
            }

            //계산
            for (int col = 0; col < 100; col++) {
                int last = 0;
                for (int row = 0; row < 100; row++) {
                    int num = board[row][col];
                    if(num != 0){
                        if (num == 2 && last == 1){
                            count++;
                        }
                        if (num != 0) last = num;
                    }
                }
            }

            System.out.println("#" + (loop + 1) + " " + count);
        }


        br.close();
    }
}

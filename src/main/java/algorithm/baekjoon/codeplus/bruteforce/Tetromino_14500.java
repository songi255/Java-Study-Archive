package algorithm.baekjoon.codeplus.bruteforce;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Tetromino_14500 {
    static int N;
    static int M;
    static int[][] board;
    static int max;
    static int[][][] blocks = new int[][][]{
            {{1,1,1,1}},
            {{1},{1},{1},{1}},

            {{1,1},{1,1}},

            {{1,0},{1,0},{1,1}},
            {{1,1,1},{1,0,0}},
            {{1,1},{0,1},{0,1}},
            {{0,0,1},{1,1,1}},
            {{0,1},{0,1},{1,1}},
            {{1,0,0},{1,1,1}},
            {{1,1},{1,0},{1,0}},
            {{1,1,1},{0,0,1}},

            {{1,0},{1,1},{0,1}},
            {{0,1},{1,1},{1,0}},
            {{0,1,1},{1,1,0}},
            {{1,1,0},{0,1,1}},

            {{1,1,1},{0,1,0}},
            {{0,1},{1,1},{0,1}},
            {{0,1,0},{1,1,1}},
            {{1,0},{1,1},{1,0}},
    };

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] inputs = br.readLine().split(" ");
        N = Integer.parseInt(inputs[0]);
        M = Integer.parseInt(inputs[1]);
        board = new int[N][M];
        max = 0;
        
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < input.length; j++) {
                board[i][j] = Integer.parseInt(input[j]);
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int k = 0; k < blocks.length; k++) {
                    int[][] block = blocks[k];
                    if ( ((block.length + i) <= N) && ((block[0].length + j) <= M) ){ // 범위를 벗어나지 않는다면
                        int sum = 0;
                        for (int ii = 0; ii < block.length; ii++) {
                            for (int jj = 0; jj < block[0].length; jj++) {
                                if (block[ii][jj]==1){
                                    sum += board[i+ii][j+jj];
                                }
                            }
                        }
                        if (sum > max) max = sum;
                    }
                }
            }
        }

        bw.write(String.valueOf(max)); bw.flush(); bw.close(); br.close();
    }
}

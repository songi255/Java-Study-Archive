package algorithm.samsungswexpert.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Concave {
    static int N;
    static boolean[][] board;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int loop = 0; loop < T; loop++) {
            N = Integer.parseInt(br.readLine());
            board = new boolean[N][N];
            boolean exits = false;

            for (int i = 0; i < N; i++) {
                String input = br.readLine();
                for (int j = 0; j < N; j++) {
                    board[i][j] = input.charAt(j) == '.' ? false:true;
                }
            }
            try {
                //가로세로
                for (int i = 0; i < N; i++) {
                    int rowCount = 0;
                    int colCount = 0;
                    for (int j = 0; j < N; j++) {
                        if(board[i][j]){
                            rowCount++;
                            if (rowCount == 5){
                                exits = true;
                                throw new Exception("found!");
                            }
                        }else{
                            rowCount = 0;
                        }
                        if(board[j][i]){
                            colCount++;
                            if (colCount == 5){
                                exits = true;
                                throw new Exception("found!");
                            }
                        }else{
                            colCount = 0;
                        }
                    }
                }

                //대각선
                for (int i = 0; i <= (N-5)/2; i++) {
                    int rightDownCount1 = 0;
                    int rightDownCount2 = 0;
                    int rightUpCount1 = 0;
                    int rightUpCount2 = 0;
                    for (int j = 0; j < N-(i*2); j++) { // 칸 수
                        if (board[i + j][j]){
                            rightDownCount1++;
                            if (rightDownCount1 == 5){
                                exits = true;
                                throw new Exception("found!");
                            }
                        }else{
                            rightDownCount1 = 0;
                        }
                        if (board[j][i + j]){
                            rightDownCount2++;
                            if (rightDownCount2 == 5){
                                exits = true;
                                throw new Exception("found!");
                            }
                        }else{
                            rightDownCount2 = 0;
                        }
                        if (board[N - 1 - i - j][j]){
                            rightUpCount1++;
                            if (rightUpCount1 == 5){
                                exits = true;
                                throw new Exception("found!");
                            }
                        }else{
                            rightUpCount1 = 0;
                        }
                        if (board[j][N - 1 - i - j]){
                            rightUpCount2++;
                            if (rightUpCount2 == 5){
                                exits = true;
                                throw new Exception("found!");
                            }
                        }else{
                            rightUpCount2 = 0;
                        }
                    }
                }
            }catch (Exception e){}

            System.out.println("#" + (loop+1) + " " + (exits ? "YES" : "NO"));
        }
        br.close();
    }
}

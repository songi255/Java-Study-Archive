package algorithm.samsungswexpert.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class OthelloGame {
    static int N;
    static int M;
    static int[][] board;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int loop = 0; loop < T; loop++) {
            String[] inputs = br.readLine().split(" ");
            N = Integer.parseInt(inputs[0]);
            M = Integer.parseInt(inputs[1]);
            board = new int[N][N];

            int mid = N / 2;
            board[mid][mid] = 2;
            board[mid-1][mid-1] = 2;
            board[mid-1][mid] = 1;
            board[mid][mid-1] = 1;

            for (int i = 0; i < M; i++) {
                inputs = br.readLine().split(" ");
                int x = Integer.parseInt(inputs[0]);
                int y = Integer.parseInt(inputs[1]);
                int bw = Integer.parseInt(inputs[2]);
                for (int j = -1; j <= 1; j++) {
                    for (int k = -1; k <= 1; k++) {
                        turn(x-1,y-1,-1 * bw, j, k);
                    }
                }
            }

            int blackCount = 0;
            int whiteCount = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (board[i][j] == 1) blackCount++;
                    else if (board[i][j] == 2) whiteCount++;
                }
            }
            System.out.println("#" + (loop + 1) + " " + blackCount + " " + whiteCount);
        }
        br.close();
    }

    public static boolean turn(int x, int y, int bw, int vertical, int horizontal){
        if (!(vertical == 0 && horizontal == 0)){ // 둘 다 0 이 아닐떄에만
            int nextX = x + vertical;
            int nextY = y + horizontal;
            if (bw < 0){ // 첫 호출일 때
                if ( nextX >= 0 && nextX < N && nextY >= 0 && nextY < N ){
                    board[x][y] = -1 * bw;
                    turn(nextX, nextY, board[x][y], vertical, horizontal);
                }
            } else if (board[x][y] == bw){ // 같은 바둑알
                return true;
            }else if (board[x][y] == (3-bw)){ // 다른 바둑알
                if ( nextX >= 0 && nextX < N && nextY >= 0 && nextY < N ){
                    if(turn(nextX, nextY, bw, vertical, horizontal)){
                        board[x][y] = bw;
                        return true;
                    };
                }
            }
        }
        return false;
    }
}

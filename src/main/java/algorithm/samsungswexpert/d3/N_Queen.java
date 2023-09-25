package algorithm.samsungswexpert.d3;

import java.util.Scanner;

public class N_Queen {
    static int count = 0;
    static int N = 0;
    static int[][] board;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int loop = 0; loop < T; loop++) {
            N = scanner.nextInt();
            board = new int[N][N];
            
            count = 0;
            dfs(N, 0, 0);            

            System.out.println("#" + (loop + 1) + " " + count);
        }

        scanner.close();
    }

    public static void dfs(int depth, int startRow, int startCol){
        if (depth == 0){
            count ++;
        }else{
            for (int i = startRow; i < N; i++) {
                int realStart = (i == startRow) ? startCol : 0;
                for (int j = realStart; j < N; j++) {
                    if (board[i][j] == 0){
                        mod(i,j,1);
                        dfs(depth - 1, i, j);
                        mod(i,j,-1);
                    }
                }
            }
        }
    }
    
    public static void mod(int row, int col, int mod){
        for (int i = 0; i < N; i++) {
            board[row][i] += mod;
            board[i][col] += mod;

            int rowTemp = row - i; int colTemp = col - i;
            if(rowTemp >= 0 && rowTemp < N && colTemp >= 0 && colTemp < N ) board[rowTemp][colTemp] += mod;
            rowTemp = row - i; colTemp = col + i;
            if(rowTemp >= 0 && rowTemp < N && colTemp >= 0 && colTemp < N ) board[rowTemp][colTemp]+= mod;
            rowTemp = row + i; colTemp = col - i;
            if(rowTemp >= 0 && rowTemp < N && colTemp >= 0 && colTemp < N ) board[rowTemp][colTemp]+= mod;
            rowTemp = row + i; colTemp = col + i;
            if(rowTemp >= 0 && rowTemp < N && colTemp >= 0 && colTemp < N ) board[rowTemp][colTemp]+= mod;
        }

    }
}

package algorithm.samsungswexpert.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SimpleBinaryCipher {
    static int N;
    static int M;
    static int sum = 0;
    static int maxLength = 56;
    static char[][] board;
    static char[][] cipher;
    static int[] translatedCipher = new int[8];

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        cipher = new char[][]{
                {'0','0','0','1','1','0','1'},
                {'0','0','1','1','0','0','1'},
                {'0','0','1','0','0','1','1'},
                {'0','1','1','1','1','0','1'},
                {'0','1','0','0','0','1','1'},
                {'0','1','1','0','0','0','1'},
                {'0','1','0','1','1','1','1'},
                {'0','1','1','1','0','1','1'},
                {'0','1','1','0','1','1','1'},
                {'0','0','0','1','0','1','1'}};


        for (int loop = 0; loop < T; loop++) {
            String[] inputs = br.readLine().split(" ");
            N = Integer.parseInt(inputs[0]);
            M = Integer.parseInt(inputs[1]);
            sum = 0;
            board = new char[N][M];
            //입력
            for (int i = 0; i < N; i++) {
                board[i] = br.readLine().toCharArray();
            }

            int startIdx = M - maxLength;
            int row = 0;
            int endCol = 0;
            Outer : for (int i = 0; i < N; i++) {
                for (int j = M - 1; j >= 55; j--) {
                    if (board[i][j] == '1'){
                        row = i;
                        endCol = j;
                        break Outer;
                    }
                }
            }

            sum = check(row, endCol);

            System.out.println("#" + (loop+1) + " " + sum);
        }


        br.close();
    }

    public static int check(int row, int endCol){
        int startCol = endCol - maxLength + 1;
        //번역
        for (int i = startCol; i < startCol + maxLength; i += 7) {
            int match = -1;
            Match : for (int k = 0; k < 10; k++) {
                for (int l = 0; l < 7; l++) {
                    if (cipher[k][l] != board[row][i+l]){
                        continue Match;
                    }else if (l == 6){
                        match = k;
                        break Match;
                    }
                }
            }
            translatedCipher[(i-startCol)/7] = match;
        }

        //체크
        int oddSum = 0;
        int evenSum = 0;
        for (int i = 0; i <= 6; i += 2) {
            oddSum += translatedCipher[i];
        }

        for (int i = 1; i <= 7; i += 2) {
            evenSum += translatedCipher[i];
        }

        return ( ( (oddSum * 3 + evenSum) % 10 ) == 0) ? oddSum + evenSum : 0;
    }
}

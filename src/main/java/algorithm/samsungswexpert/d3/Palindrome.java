package algorithm.samsungswexpert.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Palindrome {
    static char[][] board = new char[8][8];

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int loop = 0; loop < 10; loop++) {
            int length = Integer.parseInt(br.readLine());
            int count = 0;
            //입력
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    board[i][j] = (char)br.read();
                }
                br.read();
            }

            //계산
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8 - (length - 1); j++) {
                    boolean verticalFound = true;
                    boolean horizontalFound = true;
                    for (int k = 0; k < length/2; k++) {
                        if (board[i][j+k] != board[i][j+(length - k - 1)]){
                            horizontalFound = false;
                            break;
                        }
                    }
                    for (int k = 0; k < length/2; k++) {
                        if (board[j+k][i] != board[j+(length - k - 1)][i]){
                            verticalFound = false;
                            break;
                        }
                    }
                    if (verticalFound) count++;
                    if (horizontalFound) count++;
                }
            }
            System.out.println("#" + (loop+1) + " " + count);
        }
        br.close();
    }
}

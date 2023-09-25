package algorithm.samsungswexpert.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Palindrome2 {
    static char[][] board = new char[100][100];
    static int max;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int loop = 1; loop <= 10; loop++) {
            br.readLine();
            max = 1;

            // 입력
            for (int i = 0; i < 100; i++) {
                String inputs = br.readLine();
                for (int j = 0; j < 100; j++) {
                    board[i][j] = inputs.charAt(j);
                }
            }

            Outer : for (int length = 100; length >= 2; length--) {
                for (int i = 0; i < 100; i++) {
                    for (int j = 0; j < 100-(length-1); j++) {
                        boolean rowFound = true;
                        boolean colFound = true;
                        for (int k = 0; k < length/2; k++) {
                            if (board[i][j+k] != board[i][j+(length-1 - k)]){
                                rowFound = false;
                                break;
                            }
                        }
                        for (int k = 0; k < length/2; k++) {
                            if (board[j+k][i] != board[j+(length-1 - k)][i]){
                                colFound = false;
                                break;
                            }
                        }
                        if (rowFound || colFound){
                            max = length;
                            break Outer;
                        }
                    }
                }
            }

            System.out.println("#" + loop + " " + max);
        }
        br.close();
    }
}

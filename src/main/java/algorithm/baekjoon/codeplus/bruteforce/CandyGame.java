package algorithm.baekjoon.codeplus.bruteforce;

/*
문제

가장 처음에 N×N크기에 사탕을 채워 놓는다.
사탕의 색은 모두 같지 않을 수도 있다.
상근이는 사탕의 색이 다른 인접한 두 칸을 서로 교환한다.
같은 색으로 이루어져 있는 가장 긴 연속 부분(행 또는 열) 모두 먹는다.

사탕이 채워진 상태가 주어졌을 때, 상근이가 먹을 수 있는 사탕의 최대 개수를 구하는 프로그램을 작성하시오.

입력
첫째 줄 : 보드의 크기 N이 주어진다. (3 ≤ N ≤ 50)

다음 N개 줄 : 사탕의 색상이 주어진다.
- 빨간색은 C, 파란색은 P, 초록색은 Z, 노란색은 Y로 주어진다.
- 사탕의 색이 다른 인접한 두 칸이 존재하는 입력만 주어진다.

출력
먹을 수 있는 사탕의 최대 개수를 출력한다.

예제 입력 1
3
CCP
CCP
PPC
예제 출력 1
3

예제 입력 2
4
PPPP
CYZY
CCPY
PPCC
예제 출력 2
4

예제 입력 3
5
YCPZY
CYZZP
CCPPP
YCYZC
CPPZZ
예제 출력 3
4
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CandyGame {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[][] arr = new char[N][N];
        int maxValue = 0;

        // 데이터 입력
        for (int i = 0; i < N; i++) {
            String temp = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = temp.charAt(j);
            }
        }
        br.close();

        // 바꾸지 않은 채 확인
        for (int i = 0; i < N; i++) {
            maxValue = Math.max(maxValue, verticalCount(arr, i));
            maxValue = Math.max(maxValue, horizontalCount(arr, i));
        }

        if (maxValue!=N){ // 처음부터 최대케이스가 없는 경우.
            Outer : for (int i = 0; i < N-1; i++) {
                for (int j = 0; j < N; j++) {
                    if (arr[i][j]!=arr[i+1][j]){
                        verticalSwap(arr, i, j);
                        maxValue = Math.max(maxValue, verticalCount(arr, j));
                        maxValue = Math.max(maxValue, horizontalCount(arr, i));
                        maxValue = Math.max(maxValue, horizontalCount(arr, i+1));
                        verticalSwap(arr, i, j);
                    }
                    if (arr[j][i]!=arr[j][i+1]) {
                        horizontalSwap(arr, j, i);
                        maxValue = Math.max(maxValue, horizontalCount(arr, j));
                        maxValue = Math.max(maxValue, verticalCount(arr, i));
                        maxValue = Math.max(maxValue, verticalCount(arr, i + 1));
                        horizontalSwap(arr, j, i);
                    }
                    if (maxValue == N) break Outer;
                }
            }
        }
        System.out.println(maxValue);
    }
    static void verticalSwap(char[][] arr, int row, int col){
        char temp;
        temp = arr[row][col];
        arr[row][col] = arr[row+1][col];
        arr[row+1][col] = temp;
    }
    static void horizontalSwap(char[][] arr, int row, int col){
        char temp;
        temp = arr[row][col];
        arr[row][col] = arr[row][col+1];
        arr[row][col + 1] = temp;
    }
    static int verticalCount(char[][] arr, int col){
        char last = 0;
        int max = 0;
        int count = 0;
        for (int i = 0; i < arr[0].length; i++) {
            if (arr[i][col] == last){
                count++;
            }else{
                count = 1;
                last = arr[i][col];
            }
            max = Math.max(max, count);
        }
        return max;
    }
    static int horizontalCount(char[][] arr, int row){
        char last = 0;
        int max = 0;
        int count = 0;
        for (int i = 0; i < arr[0].length; i++) {
            if (arr[row][i] == last){
                count++;
            }else{
                count = 1;
                last = arr[row][i];
            }
            max = Math.max(max, count);
        }
        return max;
    }
}

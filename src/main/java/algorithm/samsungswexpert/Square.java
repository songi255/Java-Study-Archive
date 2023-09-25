package algorithm.samsungswexpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
N×N 크기의 격자판이 있다.
각각의 격자는 비어 있거나(‘.’),
막혀 있다(‘#’).
이때, 막혀 있는 칸들이 하나의 정사각형을 이루는지

[입력]
첫 번째 줄에 테스트 케이스의 수 T가 주어진다.
각 테스트 케이스의 첫 번째 줄에는 격자판의 크기 N (1≤N≤20 이 주어진다.
모든 격자판에는 최소 1개 이상의 ‘#’ 칸이 있음이 보장된다.

[출력]
각 테스트 케이스마다 격자판의 막혀 있는 칸들이 하나의 정사각형을 이루면 ‘yes’를, 그렇지 않다면 ‘no’를 출력한다.

입력
3
3
...
.##
.##
4
#..#
....
....
#..#
5
.....
.###.
.###.
.###.
.....
sample_input.txt
출력
#1 yes
#2 no
#3 yes
 */
public class Square {
    public static void main(String[] args) throws Exception{
        /*
         * 첫놈을 찾는다
         *  - 길이를 확인한다
         *  - 시작점과 길이를 기준으로 전체배열을 테스트한다.
         *
         * */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int loop = Integer.parseInt(br.readLine());

        for (int i = 0; i < loop; i++) {
            int N = Integer.parseInt(br.readLine());
            char[][] arr = new char[N][N];

            // map 입력
            for (int j = 0; j < N; j++) {
                String input = br.readLine();
                for (int k = 0; k < N; k++) {
                    arr[j][k] = input.charAt(k);
                }
            }

            //시작점 찾기
            int row = 0;
            int col = 0;
            Outer : for (row = 0; row < N; row++) {
                for (col = 0; col < N; col++) {
                    if (arr[row][col]=='#') break Outer;
                }
            }

            //길이 찾기
            int length = 0;
            int temp = row;
            while(temp < N){
                if ( arr[temp++][col]=='#' ) length++;
                else break;
            }

            //정사각형 판별
            boolean isSquare = true;
            Main : for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if (j >= row && j <= row+length-1 && k >= col && k <= col+length-1){ //내부이면
                        if (arr[j][k]=='.'){
                            isSquare = false;
                            break Main;
                        }
                    }else{ //외부이면
                        if (arr[j][k]=='#'){
                            isSquare = false;
                            break Main;
                        }
                    }
                }
            }
            System.out.println("#" + (i+1) + " " + (isSquare ? "yes" : "no"));
        }
        br.close();
    }
}

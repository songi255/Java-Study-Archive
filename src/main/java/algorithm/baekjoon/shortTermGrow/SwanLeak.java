package algorithm.baekjoon.shortTermGrow;
/*
https://www.acmicpc.net/problem/3197

문제
    두 마리의 백조
    행이 R개, 열이 C개

    매일 물 공간과 접촉한 모든 빙판 공간은 녹는다.
    가로나 세로로 닿아 있는 것만 (대각선X)

    백조는 오직 물 공간에서 세로나 가로로만(대각선은 제외한다) 움직일 수 있다.
    며칠이 지나야 백조들이 만날 수 있는 지 계산하는 프로그램을 작성하시오.

    아래에는 세 가지 예가 있다.

    ...XXXXXX..XX.XXX ....XXXX.......XX .....XX..........
    ....XXXXXXXXX.XXX .....XXXX..X..... ......X..........
    ...XXXXXXXXXXXX.. ....XXX..XXXX.... .....X.....X.....
    ..XXXXX..XXXXXX.. ...XXX....XXXX... ....X......XX....
    .XXXXXX..XXXXXX.. ..XXXX....XXXX... ...XX......XX....
    XXXXXXX...XXXX... ..XXXX.....XX.... ....X............
    ..XXXXX...XXX.... ....XX.....X..... .................
    ....XXXXX.XXX.... .....XX....X..... .................
    처음               첫째 날             둘째 날

    -------------------------------------------------------------------------------------------------------------

    입력
    입력의 첫째 줄에는 R과 C가 주어진다. 단, 1 ≤ R, C ≤ 1500.

    다음 R개의 줄에는 각각 길이 C의 문자열이 하나씩 주어진다. '.'은 물 공간, 'X'는 빙판 공간, 'L'은 백조가 있는 공간으로 나타낸다.

    -------------------------------------------------------------------------------------------------------------
    출력
    첫째 줄에 문제에서 주어진 걸리는 날을 출력한다.

-------------------------------------------------------------------------------------------------------------
예제 입력 1
10 2
.L
..
XX
XX
XX
XX
XX
XX
..
.L
예제 출력 1
3

-------------------------------------------------------------------------------------------------------------
예제 입력 2
4 11
..XXX...X..
.X.XXX...L.
....XXX..X.
X.L..XXX...
예제 출력 2
2

-------------------------------------------------------------------------------------------------------------
예제 입력 3
8 17
...XXXXXX..XX.XXX
....XXXXXXXXX.XXX
...XXXXXXXXXXXX..
..XXXXX.LXXXXXX..
.XXXXXX..XXXXXX..
XXXXXXX...XXXX...
..XXXXX...XXX....
....XXXXX.XXXL...
예제 출력 3
2
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SwanLeak {
    static boolean[][] isWater;
    static boolean[][] visited;
    static int[][] glaces;
    static int[][] melting;
    static int glaceCount = 0;
    static int meltingCount = 0;
    static int row;
    static int col;
    static int swan1_row = -1;
    static int swan1_col = -1;
    static int swan2_row = -1;
    static int swan2_col = -1;

    public static void main(String[] args) throws Exception{
        // 사용변수 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int days = 0;

        // row, col 입력
        String[] rowColInput = br.readLine().split(" ");
        row = Integer.parseInt(rowColInput[0]);
        col = Integer.parseInt(rowColInput[1]);
        isWater = new boolean[row][col];
        visited = new boolean[row][col];
        glaces = new int[2][row * col];
        melting = new int[2][row * col];

        // map, glaces 초기화
        String temp;
        for (int i = 0; i < row; i++) {
            temp = br.readLine();
            for (int j = 0; j < col; j++) {
                switch (temp.charAt(j)){
                    case 'L':
                        if (swan1_row == -1){ swan1_row = i; swan1_col = j;
                        }else{ swan2_row = i; swan2_col = j; }
                    case '.':
                        isWater[i][j] = true;
                        break;
                    case 'X':
                        glaces[0][glaceCount] = i;
                        glaces[1][glaceCount] = j;
                        glaceCount++;
                        break;
                }
            }
        }

        while (!canMeet(swan1_row, swan1_col)){
            for (int i = 0; i < row; i++) { //visited 초기화
                Arrays.fill(visited[i], false);
            }
            melt();
            days++;
        }
        System.out.println(days);
    }

    public static void melt(){
        boolean canMelt;
        int rowTemp;
        int colTemp;
        meltingCount = 0;

        for (int i = 0; i < glaceCount; i++) {
            canMelt = false;
            rowTemp = glaces[0][i]; colTemp = glaces[1][i];
            if(rowTemp > 0 ) canMelt |= isWater[rowTemp - 1][colTemp];
            if(rowTemp < row - 1) canMelt |=  isWater[rowTemp + 1][colTemp];
            if(colTemp > 0 ) canMelt |= isWater[rowTemp][colTemp - 1];
            if(colTemp < col - 1) canMelt |= isWater[rowTemp][colTemp + 1];
            // glaces 압축
            glaces[0][i - meltingCount] = glaces[0][i];
            glaces[1][i - meltingCount] = glaces[1][i];
            if (canMelt){
                melting[0][meltingCount] = glaces[0][i];
                melting[1][meltingCount] = glaces[1][i];
                meltingCount++;
            }
        }
        glaceCount -= meltingCount;

        for (int i = 0; i < meltingCount; i++) {
            isWater[melting[0][i]][melting[1][i]] = true;
        }
    }

    public static boolean canMeet(int rowTemp, int colTemp){
        if (!visited[rowTemp][colTemp]){ //방문한적 없으면
            visited[rowTemp][colTemp] = true; //방문처리
            if (rowTemp == swan2_row && colTemp == swan2_col){ // 찾았다면
                return true;
            } else if(isWater[rowTemp][colTemp]){ // 아니면 물일 시에만
                if (rowTemp > 0 && canMeet(rowTemp - 1, colTemp) ) return true;
                if(rowTemp < row - 1 && canMeet(rowTemp + 1, colTemp)) return true;
                if(colTemp > 0 && canMeet(rowTemp, colTemp - 1)) return true;
                if(colTemp < col - 1 && canMeet(rowTemp, colTemp + 1)) return true;
            }
        }
        return false;
    }
}

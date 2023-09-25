package algorithm.samsungswexpert.learn.dp_use;

import com.sun.xml.internal.bind.v2.model.core.ID;

import java.util.Arrays;
import java.util.Scanner;

/*
* 배낭문제
* DP - memoization 사용
* N이 최대 용량일 때, M을 1씩 줄이면서, M을 포함하는경우, 포함하지 않는 경우로 계산
*
* */

public class HappyBox_5258 {
    static int N;
    static int M;
    static int[] sizes;
    static int[] prices;
    static int[][] memo;
    static int max;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int loop = 1; loop <= T; loop++) {
            N = scanner.nextInt(); //최대용량
            M = scanner.nextInt(); //물건개수

            sizes = new int[M];
            prices = new int[M];
            memo = new int[M+1][N+1];
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    memo[i][j] = -1;
                }
            }
            Arrays.fill(memo[0], 0);

            for (int i = 0; i < M; i++) {
                sizes[i] = scanner.nextInt();
                prices[i] = scanner.nextInt();
            }

            max = 0;
            dfs(N, M,0);

            System.out.println("#" + loop + " " + max);
        }

        scanner.close();
    }

    public static int dfs(int n, int m, int curValue){ //최대 용량이 n일때, m번째 물건을 넣을지? 넣기전 현재 값은 curValue임.
        if (memo[m][n] != -1){
            return memo[m][n];
        }

        if (n > 0){
            if (m == 0 && n >= prices[m]){

            }else{
                memo[m][n] = Math.max(dfs(n-sizes[m], m-1, curValue + prices[m]),dfs(n,m-1,curValue)); //넣은경우, 안넣은경우
                return memo[m][n] + curValue;
            }
        }
        return 0;
    }
}

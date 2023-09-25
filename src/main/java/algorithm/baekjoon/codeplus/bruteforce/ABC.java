package algorithm.baekjoon.codeplus.bruteforce;
/*
문제
정수 N과 K가 주어졌을 때, 다음 두 조건을 만족하는 문자열 S를 찾는 프로그램을 작성하시오.

문자열 S의 길이는 N이고, 'A', 'B', 'C'로 이루어져 있다.
문자열 S에는 0 ≤ i < j < N 이면서 S[i] < S[j]를 만족하는 (i, j) 쌍이 K개가 있다.
입력
첫째 줄에 N과 K가 주어진다. (3 ≤ N ≤ 30, 0 ≤ K ≤ N(N-1)/2)

출력
첫째 줄에 문제의 조건을 만족하는 문자열 S를 출력한다. 가능한 S가 여러 가지라면, 아무거나 출력한다. 만약, 그러한 S가 존재하지 않는 경우에는 -1을 출력한다.

예제 입력 1
3 3
예제 출력 1
ABC

예제 입력 2
3 0
예제 출력 2
CBA

예제 입력 3
5 10
예제 출력 3
-1

예제 입력 4
15 36
예제 출력 4
CABBACCBAABCBBB
 */


import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ABC {
    static int N;
    static int K;
    static byte[] str;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        K = Integer.parseInt(input[1]);
        str = new byte[N];

        if (search(0,0,0,0,0)){
            System.out.println(new String(str));
        }else{
            System.out.println(-1);
        }

        br.close();
    }

    static boolean search(int idx, int a, int b, int c, int k){

        if (idx >= N){ // 최고지점 도달했으면
            if (k == K) return true;
        }else{ // 아직 만드는 중이면
            //a
            str[idx] = 'A';
            if(k<=K && search(idx+1,a+1,b,c,k)) return true;
            //b
            str[idx] = 'B';
            if(k<=K && search(idx+1,a,b+1,c,k+a)) return true;
            //c
            str[idx] = 'C';
            if(k<=K && search(idx+1,a,b,c+1,k+a+b)) return true;
        }
        return false;
    }
}

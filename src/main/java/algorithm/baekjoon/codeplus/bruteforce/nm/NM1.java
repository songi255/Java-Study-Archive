package algorithm.baekjoon.codeplus.bruteforce.nm;
//https://www.acmicpc.net/problem/15649

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


// 스택순열 구하기인데, DFS를 사용하면 가능하다!!
public class NM1 {
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int M;
    static List<Integer> list1 = new LinkedList<>();
    static List<Integer> list2 = new LinkedList<>();


    public static void main(String[] args) throws Exception{
        Scanner scanner = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = scanner.nextInt();
        M = scanner.nextInt();
        for(int i = 0; i <= N; i++){
            list1.add(i);
        }

        pick(N, M);

        bw.write(sb.toString()); bw.flush(); bw.close();scanner.close();
    }
    public static void pick(int N, int M){
        if (M==0){
            for(int j = 0; j < list2.size()-1; j++){
                sb.append(list2.get(j)).append(' ');
            }
            sb.append(list2.get(list2.size()-1)).append('\n');
        }else {
            for (int i = 1; i <= N; i++) {
                int temp = list1.remove(i);
                list2.add(temp);
                pick(N - 1, M - 1);
                list2.remove(list2.indexOf(temp));
                list1.add(i, temp);
            }
        }
    }
}

/* 순서쌍이 아니고 조합인 경우
    public static void pick(int from, int M){
        for(int i = from; i <= N-M+1; i++){
            stack[NM1.M-M] = i;
            if(M == 1){ // 마지막 원소이면
                for (int j = 0; j < NM1.M; j++) {
                    sb.append(stack[j]).append((j==NM1.M-1 ? '\n' : ' '));
                }
            }else{
                pick(i+1, M-1);
            }
        }
 */
package algorithm.baekjoon.codeplus.bruteforce.recursive;
//https://www.acmicpc.net/problem/1759

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Stack;

public class MakePassword {
    static int L;
    static int C;
    static char[] characters;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static Stack<Character> stack = new Stack<>();

    public static void main(String[] args) throws Exception{
        String[] firstLine = br.readLine().split(" ");
        L = Integer.parseInt(firstLine[0]); // 암호길이
        C = Integer.parseInt(firstLine[1]); // 문자갯수
        characters = new char[C];

        //암호조건 : 최소 1개 모음, 최소 2개 자음, 오름차순, 길이 L

        String secondLine = br.readLine();
        for (int i = 0; i < C; i++) {
            characters[i] = secondLine.charAt(2*i);
        }
        Arrays.sort(characters);

        dfs(L, 0);

        bw.write(sb.toString()); bw.flush(); bw.close(); br.close();
    }

    static void dfs(int depth, int minIdx){
        if (depth == 0){
            int vowelCount = 0; //모음
            for (char consonant : new char[]{'a', 'e', 'i', 'o', 'u'}) {
                if(stack.contains(consonant)) vowelCount++;
            }
            if (vowelCount >= 1 && L - vowelCount >= 2){
                for (int i = 0; i < L; i++) {
                    sb.append(stack.get(i));
                }sb.append('\n');
            }
        }else{
            for (int i = minIdx; i < C-depth+1; i++) {
                stack.push(characters[i]);
                dfs(depth - 1, i + 1);
                stack.pop();
            }
        }
    }
}

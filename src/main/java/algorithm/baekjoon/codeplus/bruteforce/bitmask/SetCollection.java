package algorithm.baekjoon.codeplus.bruteforce.bitmask;
//https://www.acmicpc.net/problem/11723

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;

public class SetCollection {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static int M;
    static Set<Integer> set = new HashSet<>();

    public static void main(String[] args) throws Exception{
        M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            String[] input = br.readLine().split(" ");
            String command = input[0];
            int x = 0;

            try{ x = Integer.parseInt(input[1]);}
                catch(ArrayIndexOutOfBoundsException e){}

            switch (command){
                case "add":
                    set.add(x); break;
                case "check":
                    sb.append(set.contains(x)?1:0).append('\n'); break;
                case "remove":
                    set.remove(x); break;
                case "toggle":
                     if (set.contains(x)) set.remove(x); else set.add(x);
                     break;
                case "all":
                    for (int j = 1; j <= 20; j++) {
                        set.add(j);
                    }
                    break;
                case "empty":
                    set.clear(); break;
            }
        }

        bw.write(sb.toString()); bw.flush(); bw.close(); br.close();
    }
}

package algorithm.baekjoon.codeplus.bruteforce;
//

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.List;
import java.util.Vector;

public class RemoteControl_1107 {
    static int N;
    static int M;
    static List<Character> buttons = new Vector<>();
    static int result;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine()); // 목표채널
        M = Integer.parseInt(br.readLine()); // 고장난 채널개수
        result = Math.abs(N - 100); // 옯기지 않으면
        int length = String.valueOf(N).length();

        buttons.clear();
        for (int i = 0; i <= 9; i++) {
            buttons.add((char)(i+'0'));
        }
        if (M >0){
            String[] inputs = br.readLine().split(" ");
            for (int i = 0; i < M; i++) {
                buttons.remove(Character.valueOf(inputs[i].charAt(0))); // 고장난 버튼 제거
            }
        }

        if (M != 10)
            search(length+1, new char[length+1]);
            search(length, new char[length]);
        if (length > 1){
            search(length-1, new char[length-1]);
        }

        bw.write(String.valueOf(result)); bw.flush(); bw.close(); br.close();
    }

    public static void search(int depth, char[] arr){
        if (depth == 0){
            int value = Math.abs(N - Integer.parseInt(String.valueOf(arr))) + arr.length;
            if (value < result) result = value;
        }else{
            int idx = arr.length - depth;
            for (int i = 0; i < buttons.size(); i++) {
                arr[idx] = buttons.get(i);
                search(depth-1, arr);
            }
        }
    }
}

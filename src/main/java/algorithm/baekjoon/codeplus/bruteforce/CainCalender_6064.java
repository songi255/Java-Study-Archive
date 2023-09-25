package algorithm.baekjoon.codeplus.bruteforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CainCalender_6064 {
    static int M;
    static int N;
    static int x;
    static int y;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc_count = Integer.parseInt(br.readLine());
        for (int test_case = 0; test_case < tc_count; test_case++) {
            String[] inputs = br.readLine().split(" ");
            M = Integer.parseInt(inputs[0]);
            N = Integer.parseInt(inputs[1]);
            x = Integer.parseInt(inputs[2])-1;
            y = Integer.parseInt(inputs[3])-1;

            int max = M * N;
            while(true){
                if (x == y){
                    x++;
                    break;
                }else{
                    if (x > y) y += N; else x += M;
                }
                if (x > max || y > max){
                    x = -1;
                    break;
                }
            }
            System.out.println(x);
        }

        br.close();
    }
}

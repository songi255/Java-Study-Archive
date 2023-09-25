package algorithm.samsungswexpert.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ExerciseManagement {
    static int L;
    static int U;
    static int X;


    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int loop = 0; loop < T; loop++) {
            int result = 0;
            String[] inputs = br.readLine().split(" ");
            L = Integer.parseInt(inputs[0]); // 이상
            U = Integer.parseInt(inputs[1]); // 이하
            X = Integer.parseInt(inputs[2]); // 현재

            if(X > U){
                result = -1;
            }else if (X >= L){
                result = 0;
            }else{
                result = L - X;
            }

            System.out.println("#" + ( loop + 1 ) + " " + result);
        }



        br.close();


    }
}

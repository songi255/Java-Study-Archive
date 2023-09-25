package algorithm.baekjoon.shortTermGrow;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class StringSquare_4354 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] s;
        while ((s = br.readLine().toCharArray())[0] != '.'){
            int length = s.length;
            boolean found = true;
            int result = 0;
            for (int i = 1; i <= length; i++) { // i는 sub 문자 길이
                if ((length % i) != 0) continue;
                //조건 확인
                found = true;
                Outer : for (int j = 0; j < i; j++) {
                    char c = s[j];
                    for (int k = j + i; k < length; k += i) {
                        if (c != s[k]){
                            found = false;
                            break Outer;
                        }
                    }
                }
                if (found){
                    result = length / i;
                    break;
                }
            }
            System.out.println(result);
        }

        br.close();
    }
}

package algorithm.baekjoon.codeplus.bruteforce.permutation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

public class WordMath_1339 {
    static int N;
    static List<Alphabet> list = new Vector<>();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < input.length(); j++) {
                int idx = 9 - input.length() + j;
                Alphabet a = new Alphabet(input.charAt(j));
                if (list.contains(a)) a = list.get(list.indexOf(a));
                else list.add(a);
                a.addCount(idx);
            }
        }
        list.sort(Collections.reverseOrder());
        int num = 9;
        int result = 0;
        for (int i = 0; i < list.size(); i++) {
            Alphabet a = list.get(i);
            a.value = num--;
            result += a.value();
        }

        System.out.println(result);
        br.close();
    }

    static class Alphabet implements Comparable<Alphabet>{
        char c;
        int[] count;
        int value;

        public Alphabet(char c) {
            this.c = c;
            this.count = new int[9];
        }

        public void addCount(int idx){
            count[idx]++;
            if (count[idx] == 10){
                count[idx] = 0;
                addCount(idx - 1);
            }
        }

        public int value(){
            int result = 0;
            for (int i = 0; i < 9; i++) {
                result = result * 10 + count[i];
            }
            result *= value;
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            Alphabet a = (Alphabet)obj;
            return a.c == this.c;
        }

        @Override
        public int compareTo(Alphabet a) {
            int result = 0;
            int[] a_count = a.count;
            for (int i = 0; i < 9; i++) {
                if (a_count[i] > count[i]){
                    result = -1;
                    break;
                }else if(a_count[i] < count[i]){
                    result = 1;
                    break;
                }
            }
            return result;
        }
    }
}

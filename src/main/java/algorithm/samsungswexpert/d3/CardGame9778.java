package algorithm.samsungswexpert.d3;

import java.util.Scanner;
import java.util.TreeMap;

public class CardGame9778 {
    static int N;
    static TreeMap<Integer, Integer> treeMap = new TreeMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();


        for (int loop = 1; loop <= T; loop++) {
            N = scanner.nextInt();
            //map 초기화
            for (int i = 2; i <= 9; i++) {
                treeMap.put(i, 4);
            }
            treeMap.put(10,16);
            treeMap.put(11,4);

            int score = 0;
            for (int i = 0; i < N; i++) {
                int card = scanner.nextInt();
                treeMap.compute(card, (v,c)->c-1);
                score += card;
            }
            int max = 21-score;
            int lastCardCount = 52 - N;
            int possible = 0;
            for(int i : treeMap.headMap(max, true).values()){
                possible += i;
            }

            System.out.println("#" + loop + " " + ((lastCardCount/2)<possible?"GAZUA":"STOP"));
        }


        scanner.close();
    }
}

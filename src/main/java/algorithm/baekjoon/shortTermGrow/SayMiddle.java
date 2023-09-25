package algorithm.baekjoon.shortTermGrow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

/*
https://www.acmicpc.net/problem/1655
문제

백준이는 동생에게 "가운데를 말해요" 게임을 가르쳐주고 있다. 백준이가 정수를 하나씩 외칠때마다 동생은 지금까지 백준이가 말한 수 중에서 중간값을
말해야 한다. 만약, 그동안 백준이가 외친 수의 개수가 짝수개라면 중간에 있는 두 수 중에서 작은 수를 말해야 한다.

예를 들어 백준이가 동생에게 1, 5, 2, 10, -99, 7, 5를 순서대로 외쳤다고 하면, 동생은 1, 1, 2, 2, 2, 2, 5를 차례대로 말해야 한다.
백준이가 외치는 수가 주어졌을 때, 동생이 말해야 하는 수를 구하는 프로그램을 작성하시오.

입력
첫째 줄에는 백준이가 외치는 정수의 개수 N이 주어진다. N은 1보다 크거나 같고, 100,000보다 작거나 같은 자연수이다.
그 다음 N줄에 걸쳐서 백준이가 외치는 정수가 차례대로 주어진다. 정수는 -10,000보다 크거나 같고, 10,000보다 작거나 같다.

출력
한 줄에 하나씩 N줄에 걸쳐 백준이의 동생이 말해야 하는 수를 순서대로 출력한다.

예제 입력
7
1
5
2
10
-99
7
5

예제 출력
1
1
1
2
2
2
2
5
*/
public class SayMiddle {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        final int MIN_COUNT = 1;
        final int MAX_COUNT = 100000;
        final int MIN_VALUE = -10000;
        final int MAX_VALUE = 10000;
        int temp;
        final int count;
        PriorityQueue<Integer> smallQueue = new PriorityQueue<>(Collections.reverseOrder()); //최대힙
        PriorityQueue<Integer> largeQueue = new PriorityQueue<>(); //최소힙
        int median = Integer.MAX_VALUE;

        do {
            temp = Integer.parseInt(br.readLine());
        } while(!(temp >= MIN_COUNT && temp <= MAX_COUNT)); // 예외처리
        count = temp; // N 설정

        for (int i = 0; i < count; i++) {
            temp = Integer.parseInt(br.readLine());
            if (temp >= MIN_VALUE && temp <= MAX_VALUE){ // 입력값 예외처리
                //처리코드
                if (temp > median) {
                    largeQueue.offer(temp);
                } else {
                    smallQueue.offer(temp);
                }
                //((temp > median) ? largeQueue : smallQueue).offer(temp); 한줄로 줄일 수 있네 ㄷㄷ;;

                if (largeQueue.size() > smallQueue.size()) {
                    smallQueue.offer(largeQueue.poll());
                }
                else if (smallQueue.size() - largeQueue.size() > 1){
                    largeQueue.offer(smallQueue.poll());
                }
                median = smallQueue.peek();

                sb.append(median);
                sb.append("\n");
            }else{
                //예외 입력시 다시 루프
                i--; // 좋은 코드일까?
                continue;
            }
        }
        System.out.println(sb);
    }
}

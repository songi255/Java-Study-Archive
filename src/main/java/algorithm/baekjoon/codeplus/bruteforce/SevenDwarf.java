package algorithm.baekjoon.codeplus.bruteforce;

/*
문제
난쟁이가 일곱 명 -> 아홉 명

키의 합이 100

아홉 난쟁이의 키가 주어졌을 때, 백설공주를 도와 일곱 난쟁이를 찾는 프로그램을 작성하시오.

입력
키 9줄
100을 넘지 않는 자연수이며
모두 다르며
여러 가지인 경우에는 아무거나 출력

출력
일곱 난쟁이의 키 오름차순으로 출력한다. 찾을 수 없는 경우는 없다.

예제 입력
20
7
23
19
10
15
25
8
13

예제 출력
7
8
10
13
19
20
23
*/

import java.util.Arrays;
import java.util.Scanner;

public class SevenDwarf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[9];
        int sum = 0;

        for (int i = 0; i < 9; i++) {
            arr[i] = scanner.nextInt();
            sum += arr[i];
        }
        int i = 0;
        int j = 0;

        Outer : for (i = 0; i < 8; i++) {
            for (j = i + 1; j < 9; j++) {
                if ((sum - arr[i] - arr[j]) == 100)
                    break Outer;
            }
        }

        arr[i] = Integer.MAX_VALUE;
        arr[j] = Integer.MAX_VALUE;
        Arrays.sort(arr);
        for (int k = 0; k < 7; k++) {
            System.out.println(arr[k]);
        }

        scanner.close();
    }
}

package algorithm.samsungswexpert.d3;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Game735 {
    static PriorityQueue<Integer> queue = new PriorityQueue(Comparator.reverseOrder());
    static int[] arr = new int[7];;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        for (int loop = 0; loop < T; loop++) {
            for (int i = 0; i < 7; i++) {
                arr[i] = scanner.nextInt();
            }
            queue.clear();

            insert(0, 0, 3);

            queue.poll();queue.poll();queue.poll();queue.poll();

            System.out.println("#" + (loop + 1) + " " + queue.poll());
        }

        scanner.close();
    }

    public static void insert(int sum, int from, int depth){
        if (depth == 0 && !queue.contains(sum)){
            queue.add(sum);
        }else{
            for (int i = from; i < 7; i++) {
                insert(sum + arr[i], i + 1, depth - 1);
            }
        }
    }
}

package algorithm.samsungswexpert.d3;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Password {
    public static void main(String[] args) {
        Deque<Character> deque = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);
        for (int loop = 0; loop < 10; loop++) {
            int length = scanner.nextInt();
            String password = scanner.next(); //FIXME

            for (int i = 0; i < length; i++) {
                if (deque.isEmpty()){
                    deque.offer(password.charAt(i));
                }else{
                    if (deque.peekLast() == password.charAt(i)){
                        deque.removeLast();
                    }else{
                        deque.offer(password.charAt(i));
                    }
                }
            }

            System.out.print("#" + (loop + 1) + " ");
            while (!deque.isEmpty()){
                System.out.print(deque.removeFirst());
            }
            System.out.println();
        }

        scanner.close();
    }
}

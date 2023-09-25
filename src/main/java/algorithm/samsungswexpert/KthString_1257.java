package algorithm.samsungswexpert;

import java.util.*;

public class KthString_1257 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        Queue<Atom> queue = new PriorityQueue<>();
        List<String> list = new Vector<>();

        for (int loop = 1; loop <= T; loop++) {
            queue.clear();
            list.clear();

            int k = scanner.nextInt();
            String input = scanner.next();

            for (int i = 0; i < input.length(); i++) {
                queue.offer(new Atom(input.charAt(i), i));
            }
            while(true){
                Atom atom = queue.poll();
                int idx = atom.index;
                for (int i = idx + 1; i <= input.length(); i++) {
                    String subStr = input.substring(idx, i);
                    if (!list.contains(subStr)) list.add(subStr);
                }
                if (queue.isEmpty())
                    break;
                else if (list.size() >= k && queue.peek().letter != atom.letter)
                    break;
            }
            list.sort(String::compareTo);

            String result = "none";
            if (list.size() >= k){
                result = list.get(k-1);
            }

            System.out.println("#" + loop + " " + result);
        }
        scanner.close();
    }

    static class Atom implements Comparable{
        char letter;
        int index;

        public Atom(char letter, int index) {
            this.letter = letter;
            this.index = index;
        }

        @Override
        public int compareTo(Object o) {
            Atom atom = (Atom)o;
            int result;
            if (atom.letter == this.letter)
                result = this.index - atom.index;
            else
                result = this.letter - atom.letter;

            return result;
        }
    }
}

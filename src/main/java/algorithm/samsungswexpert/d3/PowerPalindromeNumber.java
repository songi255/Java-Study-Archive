package algorithm.samsungswexpert.d3;

import java.util.Scanner;
import java.util.TreeSet;

public class PowerPalindromeNumber {
    static TreeSet<Integer> treeSet = new TreeSet<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        int i = 1;
        int pow = 1;
        while (true){
            pow = i * i;
            if (pow > 1000) break;

            if (isPalin(i) && isPalin(pow)){
                treeSet.add(pow);
            }
            i++;
        }

        for (int loop = 1; loop <= T; loop++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();

            System.out.println("#" + loop + " " + treeSet.subSet(a,true,b,true).size());
        }


        scanner.close();
    }

    public static boolean isPalin(int num){
        String str = String.valueOf(num);
        boolean isPalin = true;
        int length = str.length();
        for (int i = 0; i < length/2; i++) {
            if (str.charAt(i) != str.charAt(length-1-i)){
                isPalin = false;
                break;
            }
        }
        return isPalin;
    }
}

package algorithm.samsungswexpert.d3;

import java.util.Scanner;

public class MirrorOfString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        for (int loop = 1; loop <= T; loop++) {
            StringBuilder sb = new StringBuilder();
            char[] str = scanner.next().toCharArray();
            char c;
            for(int i = str.length - 1; i >= 0; i--){
                c = str[i];
                switch (c){
                    case 'p':
                        c = 'q';
                        break;
                    case 'q':
                        c = 'p';
                        break;
                    case 'd':
                        c = 'b';
                        break;
                    case 'b':
                        c = 'd';
                        break;
                }
                sb.append(c);
            }

            System.out.println("#" + loop + " " + sb);
        }
        scanner.close();
    }
}

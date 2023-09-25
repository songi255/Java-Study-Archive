package algorithm.samsungswexpert;

import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public class CandyDistribution {
    static int A;
    static int B;
    static int K;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = new Vector<>();

        int T = scanner.nextInt();
        for (int i = 0; i < T; i++) {
            A = scanner.nextInt();
            B = scanner.nextInt();
            K = scanner.nextInt();
            int A_save = A;
            int B_save = B;
            list.add(A);
            for (int j = 0; j < K; j++) {
                shuffle();
                list.add(A);
                if(A == A_save){
                    break;
                }
            }
            System.out.println("#" + (i+1) + " " + Math.min((list.get(K%list.size())), B));
            list.clear();
        }

        scanner.close();
    }

    public static void shuffle(){
        int P = A <= B ? A : B;
        int Q = A <= B ? B : A;
        Q = Q - P;
        P = P + P;
        A = A <= B ? P : Q;
        B = A == P ? Q : P;
    }
}

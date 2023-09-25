package algorithm.samsungswexpert.d3;

import java.util.Scanner;

public class NewOperationOfNumber {
    static int p;
    static int q;
    static int result;
    static int[] fibo = new int[100];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int loop = 0; loop < T; loop++) {
            result = 0;
            p = scanner.nextInt();
            q = scanner.nextInt();



            System.out.println("#" + (loop + 1) + " " + result);
        }

        scanner.close();
    }

    public static int shop(int x, int y){
        int col = 0;
        while (true){

        }
    }

    public static int getStartRow(int num){
        int idx = 0;
        while (true){
            if(getFibo(idx) > num){
                break;
            }else{
                idx++;
            }
        }
        return idx;
    }

    public static int getRow(int num){
        int diff = num - getFibo(getStartRow(num) - 1);
        return getStartRow(num) - diff;
    }

    public static int getCol(int num){
        int diff = num - getFibo(getStartRow(num) - 1);
        return 1 +  diff;
    }

    public static int getFibo(int idx){
        if (fibo[idx] == 0){
            if (idx == 0){
                fibo[idx] = 1;
            }else{
                fibo[idx] = getFibo(idx-1) + (idx + 1);
            }
        }
        return fibo[idx];
    }
}

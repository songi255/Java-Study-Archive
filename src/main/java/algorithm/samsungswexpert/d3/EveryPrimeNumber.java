package algorithm.samsungswexpert.d3;

public class EveryPrimeNumber {
    static final int MAX_NUM = 1000000;
    static int[] primeNums = new int[MAX_NUM + 1];

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();

        for (int i = 2; i <= MAX_NUM; i++) {
            if (primeNums[i] != -1){
                sb.append(i).append(' ');
                for (int j = i + i; j <= MAX_NUM; j+=i) {
                    primeNums[j] = -1;
                }
            }
        }
        System.out.println(sb.toString());
    }
}

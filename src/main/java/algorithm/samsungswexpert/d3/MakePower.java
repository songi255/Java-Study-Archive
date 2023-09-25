package algorithm.samsungswexpert.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MakePower {
    static int n;
    static int factor;
    static int factorCount;
    static int result;
    static int[] factors = new int[1000000];
    static int calcedFactorCount = 2;
    static{
        factors[0] = 2;
        factors[1] = 3;
    }


    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int loop = 1; loop <= T; loop++) {
            sb.append('#').append(loop).append(' ');
            n = Integer.parseInt(br.readLine());


            result = 1;
            int idx = 0;
            factor = factors[idx];
            factorCount = 0;
            while(n != 1){
                if (n%factor == 0){
                    n /= factor;
                    factorCount++;
                }else{
                    if (factorCount % 2 == 1){
                        result *= factor;
                    }
                    factorCount = 0;
                    if ( (++idx) == calcedFactorCount) calcNextPrime();
                    factor = factors[idx];
                }
            }
            if (factorCount % 2 == 1){
                result *= factor;
            }

            sb.append(result).append('\n');
        }
        System.out.println(sb);

        br.close();
    }

    public static void calcNextPrime(){
        factors[calcedFactorCount] = factors[calcedFactorCount-1] + 2;
        Outer : while(true){
            int max = (int)Math.sqrt(factors[calcedFactorCount]);
            for (int factor = 2; factor <= max; factor+=2) {
                if (factors[calcedFactorCount] % factor == 0){ // 소수가 아니면
                    factors[calcedFactorCount] += 2;
                    continue Outer;
                }
            }
            calcedFactorCount++;
            break;
        }
    }
}

package algorithm.samsungswexpert.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Knapsack {
    static int N;
    static int K;
    static int[] volumes;
    static int[] values;
    static int max;
    static int count;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int loop = 0; loop < T; loop++) {
            String[] inputs = br.readLine().split(" ");
            N = Integer.parseInt(inputs[0]); // 물건 개수
            K = Integer.parseInt(inputs[1]); // 최대용량
            volumes = new int[N];
            values = new int[N];
            max = 0;
            count = 0;

            int volume = 0;
            int value = 0;

            for (int i = 0; i < N; i++) {
                inputs = br.readLine().split(" ");
                volume = Integer.parseInt(inputs[0]);
                value = Integer.parseInt(inputs[1]);
                int containIdx = -1;
                for (int j = 0; j <= count; j++) {
                    if (volume == volumes[j]){
                        containIdx = j;
                        break;
                    }
                }
                if (containIdx == -1){
                    volumes[count] = volume;
                    values[count] = value;
                    count++;
                }else{
                    values[count] = (values[count] > value) ? values[count] : value;
                }

            }

            dfs(0,0, 0);

            System.out.println("#" + (loop + 1) + " " + max);
        }

        br.close();
    }

    public static void dfs(int sumVolumes, int sumValues, int from){
        if (sumVolumes <= K){
            max = Math.max(max, sumValues);
            for (int i = from; i < count; i++) {
                dfs(sumVolumes + volumes[i], sumValues + values[i], i+1);
            }
        }
    }
}

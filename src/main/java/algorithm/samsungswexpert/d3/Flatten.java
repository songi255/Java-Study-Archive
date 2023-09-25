package algorithm.samsungswexpert.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class Flatten {
    static TreeMap<Integer, Integer> map = new TreeMap<>();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int loop = 0; loop < 10; loop++) {
            int dump = Integer.parseInt(br.readLine());
            String[] inputs = br.readLine().split(" ");
            //입력
            map.clear();
            for (int i = 0; i < inputs.length; i++) {
                int num = Integer.parseInt(inputs[i]);
                map.compute(num, (k,v) -> (v == null) ? 1 : v + 1);
            }
            int diff = 0;
            while(dump > 0){
                Map.Entry<Integer, Integer> maxEntry = map.firstEntry();
                Map.Entry<Integer, Integer> minEntry = map.lastEntry();

                diff = maxEntry.getValue() - minEntry.getValue();
                if (diff <= dump){
                    map.compute(map.firstKey(), (k,v) -> v + maxEntry.getValue());
                    map.compute(map.lastKey(), (k,v) -> v + minEntry.getValue());
                    dump -= diff;
                }
            }

            System.out.println("#" + (loop+1) + " " + diff);
        }

        br.close();
    }
}

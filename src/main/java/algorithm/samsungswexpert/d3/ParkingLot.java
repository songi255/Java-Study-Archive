package algorithm.samsungswexpert.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class ParkingLot {
    static int n;
    static int m;
    static int income = 0;
    static int[] incomesPerWeight;
    static int[] weights;
    static TreeMap<Integer, Integer> map = new TreeMap<>();
    static PriorityQueue<Integer> parkQueue = new PriorityQueue<>();
    static Queue<Integer> waitQueue = new LinkedList<>();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        for (int loop = 0; loop < TC; loop++) {
            income = 0;
            map.clear();
            parkQueue.clear();
            waitQueue.clear();

            String[] inputs = br.readLine().split(" ");
            n = Integer.parseInt(inputs[0]); // 주차공간
            m = Integer.parseInt(inputs[1]); // 차량

            incomesPerWeight = new int[n];
            weights = new int[m];

            //queue 초기화

            for (int i = 0; i < n; i++) {
                parkQueue.offer(i);
            }

            // 주차공간 입력
            for (int i = 0; i < n; i++) {
                incomesPerWeight[i] = Integer.parseInt(br.readLine());
            }

            // 차량 입력
            for (int i = 0; i < m; i++) {
                weights[i] = Integer.parseInt(br.readLine());
            }

            for (int i = 0; i < 2 * m; i++) {
                int car = Integer.parseInt(br.readLine());
                if(car < 0){ // 빼는 동작이면
                    parkQueue.offer(map.remove((car * -1) - 1)); // 차를 뺴고, 주차공간을 확보한다.
                }else{ // 아니면 대기열에 추가
                    waitQueue.offer(car - 1); // 일단 대기열에 넣는다.
                }

                if (!parkQueue.isEmpty()){ // 주차공간이 남았으면
                    while(!waitQueue.isEmpty() && !parkQueue.isEmpty()){ // 대기차나 주차공간 하나라도 없어질 때 까지
                        int park = parkQueue.poll(); //남은 주차공간 get
                        car = waitQueue.poll(); // 대기열에서 차 get

                        income += incomesPerWeight[park] * weights[car]; //요금정산
                        map.put(car, park); // mapping
                    }
                }
            }
            System.out.println("#" + (loop + 1) + " " + income);
        }

        br.close();
    }
}

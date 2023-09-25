package algorithm.samsungswexpert.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MonarchyAndRepublican {
    static int N; //도시 수
    static int[] xs = new int[1000]; //x좌표
    static int[] ys = new int[1000]; //y좌표
    static int[] ss = new int[1000]; //군사력
    static char[] systems = new char[1000];

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int loop = 0; loop < T; loop++) {
            //입력
            N = Integer.parseInt(br.readLine());
            for (int i = 0; i < N; i++) {
                String[] inputs = br.readLine().split(" ");
                xs[i] = Integer.parseInt(inputs[0]);
                ys[i] = Integer.parseInt(inputs[1]);
                ss[i] = Integer.parseInt(inputs[2]);
            }

            sb.append('#').append(loop+1).append(' ');
            //위협 계산
            for (int defense = 0; defense < N; defense++) {
                char system = 'K'; //군주제가 기본
                double max = Integer.MIN_VALUE;
                int maxCount = 0;
                //한 도시 체크
                for (int attack = 0; attack < N; attack++) {
                    if(attack==defense) continue;

                    int x_diff = xs[defense]-xs[attack];
                    int y_diff = ys[defense]-ys[attack];
                    double threat = ( (double)ss[attack] / (x_diff*x_diff + y_diff*y_diff) );
                    if (threat > ss[defense]){
                        System.out.println("threat!!");
                        if (threat == max){
                            system = 'D';
                        }else if (threat > max){
                            max = threat;
                            system = (char)(attack + '1');
                        }
                    }
                }
                systems[defense] = system;
            }

            //정제
            for (int i = 0; i < N; i++) {
                if (systems[i] != 'K' || systems[i] != 'D'){ //숫자면
                    dfs(i);
                }
            }

            for (int i = 0; i < N-1; i++) {
                sb.append(systems[i]).append(' ');
            }sb.append(systems[N-1]).append('\n');

        }
        System.out.println(sb);

        br.close();
    }

    public static int dfs(int idx){
        if (systems[idx] == 'D' && systems[idx] == 'K'){ // 해당 도시가 정해졌으면
            return -1;
        }else{ // 숫자면
            int result = dfs(systems[idx]-1); // 정해졌는지 확인한다
            if (result == -1) { //가리키는 놈이 문자면 유지
                return systems[idx];
            }else{ //숫자면 그놈으로 바꾸고 리턴
                systems[idx] = (char)result;
                return systems[idx];
            }
        }
    }
}

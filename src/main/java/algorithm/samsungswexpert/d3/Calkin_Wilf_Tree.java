package algorithm.samsungswexpert.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Calkin_Wilf_Tree {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int loop = 0; loop < T; loop++) {
            //모든 양의 유리수 하나씩 포함
            //루트는 1/1
            // a/b이면 자식은 a/a+b   a+b/b
            Node node = new Node();
            char[] input = br.readLine().toCharArray();
            for (int i = 0; i < input.length; i++) {
                node.move(input[i]);
            }
            int a = node.getA();
            int b = node.getB();

            while(b != 0){
                int temp = a % b;
                a = b;
                b = temp;
            }

            System.out.println("#" + (loop+1) + " " + node.getA()/a + " " + node.getB()/a);
        }



        br.close();
    }

    public static class Node{
        int a;
        int b;
        Node(){
            this.a = 1;
            this.b = 1;
        }

        void move(char direction){
            if(direction == 'L'){
                b = a + b;
            }else if (direction == 'R'){
                a = a + b;
            }
        }

        public int getA() {
            return a;
        }

        public int getB() {
            return b;
        }
    }
}

package algorithm.samsungswexpert.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class Test_8888 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        TreeSet<Person> treeSet = new TreeSet<>();

        for (int loop = 1; loop <= TC; loop++) {
            String[] inputs = br.readLine().split(" ");
            int N = Integer.parseInt(inputs[0]); // 지원자 수
            int T = Integer.parseInt(inputs[1]); // 문제 가짓수
            int P = Integer.parseInt(inputs[2]); // 내 번호
            int[][] score = new int[N+1][T];

            // 점수 입력
            for (int i = 0; i < N; i++) {
                String input = br.readLine();
                for (int j = 0; j < T; j++) {
                    score[i][j] = input.charAt(j+j)-'0';
                    if (score[i][j]==0) score[N][j]++;
                }
            }

            Person me = null;
            treeSet.clear();

            for (int i = 0; i < N; i++) {
                int score_ = 0;
                int count_ = 0;
                for (int j = 0; j < T; j++) {
                    if (score[i][j] == 1){
                        score_ += score[N][j];
                        count_++;
                    }
                }
                Person person = new Person(score_, count_, i+1);
                treeSet.add(person);
                if ((i+1) == P){
                    me = person;
                }
            }

            System.out.println("#" + loop + " " + me.score + " " + treeSet.tailSet(me,true).size());
        }

        br.close();
    }

    static class Person implements Comparable{
        int score;
        int correctCount;
        int num;

        public Person(int score, int correctCount, int num) {
            this.score = score;
            this.correctCount = correctCount;
            this.num = num;
        }

        @Override
        public int compareTo(Object o){
            Person person = null;
            if (o instanceof Person){
                person = (Person)o;
            }
            int compare = this.score - person.score;
            if(compare == 0){
                compare = this.correctCount - person.correctCount;
            }
            if (compare == 0){
                compare = person.num - this.num;
            }
            return compare;
        }
    }
}

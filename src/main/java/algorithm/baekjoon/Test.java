package algorithm.baekjoon;

public class Test {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append(1000).append('\n');
        for (int i = 0; i < 1000; i++) {
            sb.append('1').append(' ');
        }
        sb.append('\n');
        System.out.println(sb.toString());
    }
}

package algorithm.baekjoon.codeplus.bruteforce.recursive;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class InequalitySign_2529 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int k;
    static char[] sign;
    static int[] nums;
    static int[] max;
    static int[] min;
    static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws Exception{
        k = Integer.parseInt(br.readLine());
        sign = new char[k];
        nums = new int[k + 1];
        max = new int[k + 1];
        min = new int[k + 1];
        Arrays.fill(min, Integer.MAX_VALUE);

        String input = br.readLine();
        for (int i = 0; i < k; i++) {
            sign[i] = input.charAt(i<<1);
        }

        for (int i = 0; i <= 9; i++) {
            stack.push(i);
        }

        search(k);
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < max.length; i++) {
            sb.append(max[i]);
        }sb.append('\n');
        for (int i = 0; i < min.length; i++) {
            sb.append(min[i]);
        }sb.append('\n');
        System.out.println(sb);
    }

    public static void search(int depth){
        if (depth == -1){
            if (compare(nums, max) > 0){
                for (int i = 0; i < nums.length; i++) {
                    max[i] = nums[i];
                }
            }
            if (compare(nums, min) < 0){
                for (int i = 0; i < nums.length; i++) {
                    min[i] = nums[i];
                }
            }
        }else{
            int idx = k - depth;
            for (int i = 0; i < stack.size(); i++) {
                int num = stack.remove(i);
                nums[idx] = num;
                if (depth == k) { // 처음 시작
                    search(depth - 1);
                }else{
                    if( (sign[idx-1] == '<') ? (nums[idx-1] < nums[idx]) : (nums[idx-1] > nums[idx]) ){ //조건에 맞다면
                        search(depth - 1);
                    }
                }
                stack.add(i, num);
            }
        }
    }

    public static int compare(int[] a, int[] b){
        int result = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] > b[i]){
                result = 1;
                break;
            }else if(a[i] < b[i]){
                result = -1;
                break;
            }
        }
        return result;
    }

}

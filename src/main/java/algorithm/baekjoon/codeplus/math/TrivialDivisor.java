package algorithm.baekjoon.codeplus.math;
//

import java.util.Arrays;
import java.util.Scanner;

public class TrivialDivisor {
    public static void main(String[] args) throws Exception{
        Scanner scanner = new Scanner(System.in);

        int loop = scanner.nextInt();
        int[] nums = new int[loop];
        scanner.nextLine();

        for (int i = 0; i < loop; i++) {
            nums[i] = scanner.nextInt();
        }

        Arrays.sort(nums);

        System.out.println(nums[0] * nums[loop-1]);

        scanner.close();
    }
}

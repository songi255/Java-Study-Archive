package algorithm.samsungswexpert.ssafy;

import java.util.Scanner;

public class Solution1 {
	static int N;
	static int[] arr;
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();
		for (int loop = 1; loop <= T; loop++) {
			N = scanner.nextInt();
			arr = new int[N];
			for (int i = 0; i < N; i++) {
				arr[i] = scanner.nextInt();
			}
			
			int result = 0;
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (i != j) {
						result += arr[i] % arr[j];
					}
				}
			}
			
			System.out.println("#" + loop + " " + result);
		}
		
		scanner.close();
	}
}

package algorithm.samsungswexpert.ssafy;

import java.util.Scanner;

public class Solution2 {
	static int N;
	static int result;
	static int evenCount;
	static int oddCount;
	
	public static void main(String[] args) throws Exception{
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();
		for (int loop = 1; loop <= T; loop++) {
			N = scanner.nextInt();
			boolean[] arr = new boolean[N];
			
			evenCount = 0;
			oddCount = 0;
			
			for (int i = 0; i < N; i++) {
				arr[i] = (scanner.nextInt()%2) == 0;
				if (arr[i]) {
					evenCount++;
				}
			}
			oddCount = N - evenCount;
			
			result = Integer.MAX_VALUE;
			switch (evenCount - oddCount) {
			case 1: check(arr, true); break;
			case 0: check(arr.clone(), true); check(arr.clone(), false); break;
			case -1: check(arr, false); break;
			default: result = -1; break;
			}
			
			System.out.println("#" + loop + " " + result);
		}
		
		scanner.close();
	}
	
	public static void check(boolean[] arr, boolean start) {
		int temp = 0;
		boolean answer = !start;
		for (int i = 0; i < arr.length; i++) {
			answer = !answer;
			if (arr[i] != answer) {
				for (int j = i+1; j < arr.length; j++) {
					if (arr[j] == answer) {
						temp += j - i;
						for (int k = j; k >= i+1; k--) {
							arr[j] = arr[j-1];
						}
						arr[i] = answer;
						break;
					}
				}
			}
		}
		result = Math.min(result, temp);
	}
}

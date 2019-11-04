import java.util.Arrays;
import java.util.Scanner;

public class LISPractice {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		int[] dp = new int[arr.length];
		for (int i = 0; i < dp.length; i++) {
			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j] && dp[i] < dp[j] + 1) {
					dp[i] = dp[j] + 1;
				}
			}
		}
//		System.out.println(Arrays.toString(dp));
		int max = Arrays.stream(dp).max().getAsInt();
		System.out.println(max);
	}

//	private static int lower_bound(int[] dp, int end, int n) {
//		int start = 0;
//		while(start < end) {
//			int mid = (start+end)/2;
//			if(dp[mid]>=n) {
//				end=mid;
//			}else {
//				start=mid+1;
//			}
//		}
//		return end;
//	}
}

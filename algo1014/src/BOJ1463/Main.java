package BOJ1463;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] dp = new int[n + 1];
		dp[1]=0;
		for (int i = 2; i <= n; i++) {
			if (i <= 3) {
				dp[i] = 1;
			} else {
				if (i % 3 == 0 && i % 2 == 0) {
					dp[i] = Math.min(dp[i / 3] + 1, Math.min(dp[i - 1] + 1, dp[i / 2] + 1));
				} else if (i % 3 == 0) {
					dp[i] = Math.min(dp[i / 3] + 1, dp[i - 1] + 1);
				} else if (i % 2 == 0) {
					dp[i] = Math.min(dp[i / 2] + 1, dp[i - 1] + 1);
				} else {
					dp[i] = dp[i - 1] + 1;
				}
			}
		}
		System.out.println(dp[n]);
	}
}

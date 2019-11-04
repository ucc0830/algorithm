package BOJ1010;
/*
 * 다리놓기
 * nCm 의 조합 경우의 수를 찾는 문제
 */
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int[][] dp;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int n = sc.nextInt(), m = sc.nextInt();
			dp = new int[m + 1][n + 1];
			for (int i = 0; i <= n; i++) {
				Arrays.fill(dp[i], -1);
			}
			int ans = func(m, n);
			System.out.println(ans);
		} // tc
	}// main

	private static int func(int n, int m) {
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= Math.min(i, m); j++) {
//				System.out.println(i+", "+j);
				if (j == 0 || j == i) {
					dp[i][j] = 1;
				} else {
					dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
				}
			}
		}
		return dp[n][m];
	}
}

package BOJ2098;

import java.util.Arrays;
import java.util.Scanner;

public class Main2 {

	static int N;
	static int[][] W;
	static final int INF = 100000000;
	static final int START = 0;
	static int[][] dp;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		W = new int[N][N];
		dp = new int[N][1 << N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				W[i][j] = sc.nextInt();
			}
		}
		for (int i = 0; i < N; i++) {
			Arrays.fill(dp[i], -1);
		}
		System.out.println(solve(START, 1 << START));
	}

	static int solve(int cur, int B) {
		System.out.println("cur : " + cur + ", B : " + B);
		if (dp[cur][B] != -1)
			return dp[cur][B];

		if (B == (1 << N) - 1) {// 모두 방문
			System.out.println("=====================");
			dp[cur][B] = W[cur][START] != 0 ? W[cur][START] : INF;
			System.out.println(dp[cur][B]);
			return dp[cur][B];
		}

		dp[cur][B] = INF;

		for (int i = 0; i < N; i++) {
			if (W[cur][i] == INF || (B & (1 << i)) > 0)//cur에서 i로 가는 길이 없거나||이미 방문했다면
				continue;
			System.out.println("?"+(B | (1 << i)));//방문한 위치값
			dp[cur][B] = Math.min(dp[cur][B], solve(i, B | (1 << i)) + W[cur][i]);
			System.out.println(dp[cur][B]);
		}

		return dp[cur][B];
	}
}

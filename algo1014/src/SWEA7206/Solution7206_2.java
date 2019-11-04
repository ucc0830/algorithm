package SWEA7206;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution7206_2 {
	static int result;
	static int dp[] = new int[100000];

	public static void main(String[] args) {
		int T;
		String str = new String();

		Scanner s = new Scanner(System.in);

		T = s.nextInt();

		for (int t = 1; t <= T; t++) {
			for (int i = 0; i < 100000; i++) {
				dp[i] = -1;
			}
			result = 0;
			str = s.next();
			System.out.println("#" + t + " " + dfs(str, 0));
		}

	}

	public static int dfs(String str, int depth) {
		if (str.length() <= 1) {
			// result = Math.max(result, depth);
			return depth;
		}
		if (dp[Integer.parseInt(str)] >= 0) {
			return dp[Integer.parseInt(str)] + depth;
		}
		boolean[] arr = new boolean[str.length()];
		// System.out.println(str);
		int d = dfs1(str, depth, 1, arr, 0);
		dp[Integer.parseInt(str)] = d - depth;
		return d;
	
	}

	public static int dfs1(String str, int depth, int k, boolean[] arr, int count) {
		if (k == str.length()) {
			if (count == 0) {
				return 0;
			}
			/*
			 * for(int i = 1 ; i < str.length() ; i++) { if(arr[i] == false) {
			 * System.out.print("0"); } else { System.out.print("1"); }
			 * } System.out.println();
			 */
			int start = 0;
			int num = 1;
			for (int i = 1; i < str.length(); i++) {
				if (arr[i] == false)
					continue;
				num *= Integer.parseInt(str.substring(start, i));
				start = i;
			}
			num *= Integer.parseInt(str.substring(start));

			return dfs(Integer.toString(num), depth + 1);
		}
		// System.out.println(depth1);
		int res;
		arr[k] = true;
		res = dfs1(str, depth, k + 1, arr, count + 1);
		arr[k] = false;
		res = Math.max(dfs1(str, depth, k + 1, arr, count), res);

		return res;
	}
}

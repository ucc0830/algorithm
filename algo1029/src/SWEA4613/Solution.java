package SWEA4613;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

	static int n, m, ans;
	static char[][] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			n = sc.nextInt();
			m = sc.nextInt();
			arr = new char[n][m];
			for (int i = 0; i < n; i++) {
				String s = sc.next();
				for (int j = 0; j < m; j++) {
					arr[i][j] = s.charAt(j);
				}
			}

			ans = Integer.MAX_VALUE;
			dfs(0, 0, n - 1, new ArrayList<Integer>());
			System.out.printf("#%d %d%n", t, ans);
		} // tc

	}// main

	private static void dfs(int idx, int cnt, int size, ArrayList<Integer> list) {
		if (cnt == 2) {
			int sum = 0;
			for (int i = 0; i < list.get(0); i++) {
				for (int j = 0; j < m; j++) {
					if (arr[i][j] != 'W')
						sum++;
				}
			}
			for (int i = list.get(0); i < list.get(1); i++) {
				for (int j = 0; j < m; j++) {
					if (arr[i][j] != 'B')
						sum++;
				}
			}
			for (int i = list.get(1); i <= size; i++) {
				for (int j = 0; j < m; j++) {
					if (arr[i][j] != 'R')
						sum++;
				}
			}
			if (ans > sum) {
				ans = sum;
			}
			return;
		}
		for (int i = idx; i < size; i++) {
			list.add(i + 1);
			dfs(i + 1, cnt + 1, size, list);
			list.remove(list.size() - 1);
		}
	}

}// class

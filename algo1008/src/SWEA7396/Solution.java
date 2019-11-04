package SWEA7396;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {
	static int[] dy = { 1, 0 }, dx = { 0, 1 };
	static int n, m;
	static String ans;

	static class pos implements Comparable<pos> {
		int y, x;
		String s;

		public pos(int y, int x, String s) {
			super();
			this.y = y;
			this.x = x;
			this.s = s;
		}

		@Override
		public int compareTo(pos o) {
			return this.s.compareTo(o.s);
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			n = sc.nextInt();
			m = sc.nextInt();
			char[][] arr = new char[n][m];
			for (int i = 0; i < n; i++) {
				String s = sc.next();
				for (int j = 0; j < m; j++) {
					arr[i][j] = s.charAt(j);
				}
			}
			// dfs(arr, 0, 0, s);
			bfs(arr, 0, 0);
			System.out.printf("#%d %s%n", t, ans);
		} // tc
	}// main

	private static void bfs(char[][] arr, int y, int x) {
		StringBuilder sb = new StringBuilder();
		sb.append(arr[0][0]);
		PriorityQueue<pos> q = new PriorityQueue<>();
		boolean[][] visited = new boolean[n][m];
		visited[y][x] = true;
		q.add(new pos(y, x, sb.toString()));
		
		while (!q.isEmpty()) {
			pos p = q.poll();
			if (p.s.length() == (n + m - 1)) {
				ans = p.s;
				break;
			}
			for (int i = 0; i < 2; i++) {
				int ny = p.y + dy[i];
				int nx = p.x + dx[i];
				if (ny >= n || nx >= m || visited[ny][nx])
					continue;
				visited[ny][nx] = true;
				q.add(new pos(ny, nx, p.s+arr[ny][nx]));
			}

		}

	}

	private static void dfs(char[][] arr, int y, int x, String s) {
		if (y == n - 1 && x == m - 1) {
			ans = s;
			return;
		}
		char ch = 255;
		int yy = 0, xx = 0;
		for (int i = 0; i < 2; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if (ny >= n || nx >= m)
				continue;
			if (ch >= arr[ny][nx]) {
				ch = arr[ny][nx];
				yy = ny;
				xx = nx;
			}
		}
		s += ch;
		System.out.println(yy + ", " + xx);
		dfs(arr, yy, xx, s);
	}
}

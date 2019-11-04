package BOJ15685;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static class Dragon {
		int x, y, d, g;

		public Dragon(int x, int y, int d, int g) {
			super();
			this.x = x;
			this.y = y;
			this.d = d;
			this.g = g;
		}
	}

	static int[] dy = { 0, 0, 1, -1 }, dx = { 1, -1, 0, 0 };
	static boolean[][] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		visited = new boolean[100][100];
		for (int i = 0; i < n; i++) {
			ArrayList<Integer> list = new ArrayList<Integer>();
			Dragon t = new Dragon(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt());

			list.add(t.d);
			for (int j = 0; j < t.g; j++) {
				int siz = list.size();
				for (int k = siz - 1; k >= 0; k--) {
					int d = list.get(k);
					d = (d + 1) % 4;
					list.add(d);
				}
			}

			visited[t.y][t.x] = true;
			check(t, list);
		}

		int ans = 0;
		for (int p = 0; p < 100; p++) {
			for (int q = 0; q < 100; q++) {
				if (visited[p][q] && visited[p + 1][q] && visited[p][q + 1] && visited[p + 1][q + 1])
					ans++;
			}
		}

		System.out.println(ans);
		print(visited);
	}

	private static void check(Dragon t, ArrayList<Integer> list) {
		for (int i = 0; i < list.size(); i++) {
			t.y += dy[list.get(i)];
			t.x += dx[list.get(i)];
			if (t.y < 0 || t.x < 0 || t.y >= 100 || t.x >= 100)
				continue;
			visited[t.y][t.x] = true;
		}
	}

	private static void print(boolean[][] visited) {
		int len = visited.length;
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				System.out.print(visited[i][j] ? "1 " : "0 ");
			}
			System.out.println();
		}
	}
}

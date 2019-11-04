package BOJ2636;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int[] dy = { 0, 1, 0, -1 }, dx = { 1, 0, -1, 0 };

	static class Pos {
		int y, x;

		public Pos(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
	}

	static boolean[][] visited;
	static boolean[][] visited2;
	static int r, c, ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		r = sc.nextInt();
		c = sc.nextInt();
		int[][] arr = new int[r][c];

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

		int time = 0;
		int cnt = 0;
		boolean flag = false;
		while (true) {
			visited = new boolean[r][c];
			visited2 = new boolean[r][c];
			bfs(arr, 0, 0);
			cnt = 0;
			for (int i = 0; i < r; i++) {
				for (int j = 0; j < c; j++) {
					if (visited2[i][j]) {
						cnt++;
						arr[i][j] = 0;
					}
				}
			}
			ans = cnt > 0 ? cnt : ans;
			if (cnt == 0)
				break;
			time++;
		}
		System.out.println(time);
		System.out.println(ans);
	}

	private static void bfs(int[][] arr, int i, int j) {
		Queue<Pos> q = new LinkedList<Main.Pos>();
		q.add(new Pos(i, j));
		visited[i][j] = true;

		while (!q.isEmpty()) {
			Pos cur = q.poll();
			for (int z = 0; z < 4; z++) {
				int ny = cur.y + dy[z];
				int nx = cur.x + dx[z];
				if (ny < 0 || nx < 0 || ny >= r || nx >= c || visited[ny][nx])
					continue;
				if (arr[ny][nx] == 1) {
					visited2[ny][nx] = true;
					continue;
				}
				visited[ny][nx] = true;
				q.add(new Pos(ny, nx));
			}
		}
	}
}

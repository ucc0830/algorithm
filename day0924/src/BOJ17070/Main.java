package BOJ17070;

import java.util.Scanner;

public class Main {

	static boolean[][] visited;
	static int[] dy = { 0, 1, 1 }, dx = { 1, 0, 1 };
	static int n;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int[][] arr = new int[n + 1][n + 1];
		visited = new boolean[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

		dfs(0, 1, 2, arr);// 0, 1, 2 = 가로, 세로, 대각선

	}

	private static void dfs(int d, int y, int x, int[][] arr) {

		visited[y][x] = true;

		switch (d) {
		case 0:
			for (int z = 0; z < 3; z += 2) {
				int ny = y + dy[z];
				int nx = x + dx[z];

				if (ny < 0 || nx < 0 || ny > n || nx > n || arr[ny][nx] == 1)
					continue;
				
				
			}
			break;
		case 1:
			for (int z = 1; z < 3; z++) {
				int ny = y + dy[z];
				int nx = x + dx[z];

				if (ny < 0 || nx < 0 || ny > n || nx > n || arr[ny][nx] == 1)
					continue;
			}
			break;
		case 2:
			for (int z = 0; z < 3; z++) {
				int ny = y + dy[z];
				int nx = x + dx[z];

				if (ny < 0 || nx < 0 || ny > n || nx > n || arr[ny][nx] == 1)
					continue;
			}
			break;
		}

	}

}

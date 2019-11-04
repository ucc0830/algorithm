package BOJ4963;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int[] dy = { -1, -1, -1, 0, 0, 1, 1, 1 }, dx = { -1, 0, 1, -1, 1, -1, 0, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			int w = sc.nextInt();
			int h = sc.nextInt();
			if (w == 0 && h == 0)
				break;
			int[][] arr = new int[h][w];
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			int ans = 0;
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (arr[i][j] == 1) {
						bfs(arr, w, h, i, j);
						ans++;
					}
				}
			}
			System.out.println(ans);
		} // tc

	}

	private static void bfs(int[][] arr, int w, int h, int i, int j) {
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] { i, j });
		while (!q.isEmpty()) {
			int[] t = q.poll();
			for (int z = 0; z < 8; z++) {
				int ny = t[0] + dy[z];
				int nx = t[1] + dx[z];
				if (ny < 0 || nx < 0 || ny >= h || nx >= w || arr[ny][nx]==0)
					continue;
				if(arr[ny][nx]==1) {
					arr[ny][nx]=0;
					q.add(new int[] {ny,nx});
				}
			}
		}
	}
}

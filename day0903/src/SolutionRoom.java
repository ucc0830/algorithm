import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/*
 * 정사각형 방
 */
public class SolutionRoom {
	static int tmp, ans, num;
	static int[] dy = { 1, -1, 0, 0 }, dx = { 0, 0, 1, -1 };
	static int N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			ans = 1;
			num = Integer.MAX_VALUE;
			N = sc.nextInt();
			int[][] map = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					tmp = 1;
					dfs(i, j, map);
					if (ans <= tmp) {
						if(ans<tmp) {
							ans = tmp;
							num=map[i][j];
						}
						else {
							ans=tmp;
							if(map[i][j]<num)
								num=map[i][j];
						}
					}
				}
			}
			System.out.printf("#%d %d %d\n", t, num, ans);

		} // tc

	}// main

	private static void dfs(int y, int x, int[][] map) {
		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if (ny < 0 || nx < 0 || ny >= N || nx >= N)
				continue;
			if (map[y][x] + 1 == map[ny][nx]) {
				tmp++;
				dfs(ny, nx, map);
			}
		}
	}
}// class

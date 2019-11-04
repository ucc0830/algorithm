package BOJ16236;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int N;
	static int[][] arr;
	static int[] dy = { 1, -1, 0, 0 }, dx = { 0, 0, -1, 1 };

	static class shark {
		int y, x, size, cnt;

		public shark(int y, int x, int size, int cnt) {
			super();
			this.y = y;
			this.x = x;
			this.size = size;
			this.cnt = cnt;
		}
	}

	static shark sha;

	public static void main(String[] args) {
		input();
		solve();
	}

	private static void solve() {
		int time = 0;
		while (true) {// 잡을 먹이가 없을때 까지
			Queue<int[]> q = new LinkedList<int[]>();
			boolean[][] visited = new boolean[N][N];

			boolean flag = false;
			q.add(new int[] { sha.y, sha.x });// 상어좌표
			visited[sha.y][sha.x] = true;
			int dist = 0;
			int nextSY = N, nextSX = N;

			wh: while (!q.isEmpty()) {// 상어 1회 이동
				dist++;
				int siz = q.size();
				for (int i = 0; i < siz; i++) {
					int[] t = q.poll();

					for (int z = 0; z < 4; z++) {
						int ny = t[0] + dy[z];
						int nx = t[1] + dx[z];
						if (ny < 0 || nx < 0 || ny >= N || nx >= N || visited[ny][nx] || sha.size < arr[ny][nx])
							continue;
						if (arr[ny][nx] > 0 && sha.size > arr[ny][nx]) {// 먹을 수 있다.
							flag = true;
							if (ny < nextSY) {
								nextSY = ny;
								nextSX = nx;
							} else if (ny == nextSY) {
								if (nx < nextSX) {
									nextSY = ny;
									nextSX = nx;
								}
							}
						}
						visited[ny][nx] = true;
						q.add(new int[] { ny, nx });
					}
				} // loop(qsize)

				if (flag) {// 이동할 곳이 있다.
					arr[sha.y][sha.x] = 0;
					arr[nextSY][nextSX] = 0;
					time += dist;
					sha.y = nextSY;
					sha.x = nextSX;
					sha.cnt++;
					if (sha.cnt == sha.size) {
						sha.size++;
						sha.cnt = 0;
					}
					break wh;
				}

			} // while(wh)
			if (!flag) {// 더 이상 먹을 물고기가 없다.
				System.out.println(time);
				return;
			}
		} // while
	}// solve

	private static void input() {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N][N];
		sha = new shark(0, 0, 2, 0);
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				arr[i][j] = sc.nextInt();
				if (arr[i][j] == 9) {
					sha.y = i;
					sha.x = j;
				}
			}
		}
	}

}

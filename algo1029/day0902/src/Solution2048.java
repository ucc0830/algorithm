import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution2048 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int ans;

	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());
		int[][] map = new int[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dfs(0, map);
		System.out.println(ans);
	}

	private static void dfs(int cnt, int[][] map) {
		if (cnt == 5) {
			return;
		}

		for (int i = 0; i < 4; i++) {
			int[][] mapp = move(map, i);
			for (int j = 0; j < mapp.length; j++) {
				for (int k = 0; k < mapp.length; k++) {
					ans = ans > mapp[j][k] ? ans : mapp[j][k];
				}
			}
			dfs(cnt + 1, mapp);
		}

	}

	private static int[][] move(int[][] map, int dir) {
		Queue<Integer> q = new LinkedList<Integer>();
		int[][] rmap = new int[map.length][map.length];

		switch (dir) {
		case 0:// 상
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map.length; j++) {
					if (map[j][i] == 0)
						continue;
					q.add(map[j][i]);
				}
				int idx = 0;
				while (!q.isEmpty()) {
					int ver1 = q.poll();

					if (!q.isEmpty() && (q.peek() == ver1)) {
						q.poll();
						rmap[idx][i] = ver1 * 2;
					} else {
						rmap[idx][i] = ver1;
					}
					idx++;
				}

			}

			break;
		case 1:// 하
			for (int i = 0; i < map.length; i++) {
				for (int j = map.length - 1; j >= 0; j--) {
					if (map[j][i] == 0)
						continue;
					q.add(map[j][i]);
				}
					int idx = map.length - 1;
					while (!q.isEmpty()) {
						int ver1 = q.poll();

						if (!q.isEmpty() && q.peek() == ver1) {
							q.poll();
							rmap[idx][i] = ver1 * 2;
						} else {
							rmap[idx][i] = ver1;
						}
						idx--;
					}

			}
			break;
		case 2:// 좌
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map.length; j++) {
					if (map[i][j] == 0)
						continue;
					q.add(map[i][j]);
				}
					int idx = 0;
					while (!q.isEmpty()) {
						int ver1 = q.poll();

						if (!q.isEmpty() && q.peek() == ver1) {
							q.poll();
							rmap[i][idx] = ver1 * 2;
						} else {
							rmap[i][idx] = ver1;
						}
						idx++;
					}

			}
			break;
		case 3:// 우
			for (int i = 0; i < map.length; i++) {
				for (int j = map.length - 1; j >= 0; j--) {
					if (map[i][j] == 0)
						continue;
					q.add(map[i][j]);
				}
					int idx = map.length-1;
					while (!q.isEmpty()) {
						int ver1 = q.poll();

						if (!q.isEmpty() && q.peek() == ver1) {
							q.poll();
							rmap[i][idx] = ver1 * 2;
						} else {
							rmap[i][idx] = ver1;
						}
						idx--;
					}

			}
			break;
		}

		return rmap;

	}
}

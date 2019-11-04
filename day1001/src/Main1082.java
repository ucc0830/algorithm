
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main1082 {

	static int R; // 세로행(Y좌표)
	static int C; // 가로열(X좌표)
	static int[][] map;
	static int startY;// 고슴도치 행(D)(R값)
	static int startX; // 고슴도치 열(D)(C값)
	static int endY;// 비버 열(S)(R값)
	static int endX; // 비버 행(S)(C값)
	static boolean finish;
	static int count;// 고슴도치 이동 count, 초기화 필요
	static int[][] direction = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	static Queue<int[]> goQueue = new LinkedList<int[]>();
	static Queue<int[]> waterQueue = new LinkedList<int[]>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine().trim());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new int[R][C];

		for (int i = 0; i < R; i++) {
			String str = br.readLine().trim();
			for (int j = 0; j < C; j++) {

				if (str.charAt(j) == 'D') {// 비버의 위치 기억
					map[i][j] = -9;
					endX = i;
					endY = j;
				} else if (str.charAt(j) == 'S') {// 고슴도치의 위치 기억
					map[i][j] = 0;
					startX = i;
					startY = j;
					goQueue.offer(new int[] { i, j });
				} else if (str.charAt(j) == '*') {// 물의 위치 기억
					map[i][j] = 1;
					waterQueue.offer(new int[] { i, j });

				} else if (str.charAt(j) == 'X') {// 돌의 위치 기억
					map[i][j] = -1;
				}
			}
		}

		waterbfs();
		gobfs();

		if (finish) {
			System.out.println(map[endX][endY] - 1);
		} else {
			System.out.println("impossible");
		}

	}// end main

	// 물bfs(돌=-1 갈수없음 물은 4방향으로 한칸씩 증가)
	public static void waterbfs() {
		int newX = 0;
		int newY = 0;
		int temp[] = null;
		while (!waterQueue.isEmpty()) {
			temp = waterQueue.poll();
			count = map[temp[0]][temp[1]];

			for (int i = 0; i < 4; i++) {
				newX = temp[0] + direction[i][0];
				newY = temp[1] + direction[i][1];
				if (newX >= 0 && newX < R && newY >= 0 && newY < C && map[newX][newY] == 0) {
					waterQueue.offer(new int[] { newX, newY });
					map[newX][newY] = count + 1;
				}
			}
		}
	}// end waterbfs

	// 고슴도치bfs(돌=-1 갈수없음)
	public static void gobfs() {

		map[startX][startY] = 1;

		int newX = 0;
		int newY = 0;
		int temp[] = null;

		while (!goQueue.isEmpty()) {
			temp = goQueue.poll();

			count = map[temp[0]][temp[1]];

			for (int i = 0; i < 4; i++) {
				newX = temp[0] + direction[i][0];
				newY = temp[1] + direction[i][1];

				if (newX >= 0 && newX < R && newY >= 0 && newY < C
						&& (map[newX][newY] == -9 || map[newX][newY] == 0 || count + 1 < map[newX][newY])) {
					map[newX][newY] = count + 1;

					if (newX == endX && newY == endY) {
						finish = true;
						return;
					}
					goQueue.offer(new int[] { newX, newY });

				}
			}
		}
	}// end gobfs

}// end class
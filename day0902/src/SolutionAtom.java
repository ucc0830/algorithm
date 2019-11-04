import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 원자소멸
 * 1. 위치, 방향, 에너지가 주어진다.
 * 2. 겹치면 충돌 후 에너지방출
 */
public class SolutionAtom {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static class Atom {
		int x, y, d, k;

		public Atom(int x, int y, int d, int k) {
			super();
			this.x = x;
			this.y = y;
			this.d = d;
			this.k = k;
		}
	}

	static int[] dy = { 1, -1, 0, 0 }, dx = { 0, 0, -1, 1 };// 상하좌우
	static int ans;
	static int[][] map = new int[4001][4001];
	public static void main(String[] args) throws Exception {
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			Queue<Atom> list = new LinkedList<>();
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int d = Integer.parseInt(st.nextToken());
				int k = Integer.parseInt(st.nextToken());
				x = (2 * x) + 2000;
				y = (2 * y) + 2000;
//				y = 4000 - y;
				list.add(new Atom(x, y, d, k));
			}
			ans = solve(list);
			System.out.printf("#%d %d\n", t, ans);
		} // tc

	}// main
	

	private static int solve(Queue<Atom> list) {
		int result = 0;
		
		while (!list.isEmpty()) {
			Atom a = list.poll();// 하나씩 뺀다.
			int ty = a.y + dy[a.d];
			int tx = a.x + dx[a.d];

			if (map[a.y][a.x] != a.k && map[a.y][a.x] != 0) {// 기존 에너지 보다 크면 충돌
				result += map[a.y][a.x];
				map[a.y][a.x] = 0;
				continue;
			}

			map[a.y][a.x] = 0;
			
			if (ty < 0 || tx < 0 || ty > 4000 || tx > 4000) {
				map[a.y][a.x] = 0;
				continue;
			}
			
			if (map[ty][tx] != 0) {
				map[ty][tx] += a.k;
			} else {
				map[ty][tx] = a.k;
				list.add(new Atom(tx, ty, a.d, a.k));
			}
		} // while
		
		return result;
	}

}// class

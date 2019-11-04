import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main13459 {

	static BufferedReader br;
	static StringTokenizer st;
	static int N, M;
	static int[] dy = { 0, 0, 1, -1 }, dx = { 1, -1, 0, 0 };
	static boolean[][][][] chk;

	static class Pos {
		int ry, rx, by, bx, dep;

		public Pos(int ry, int rx, int by, int bx, int dep) {
			super();
			this.ry = ry;
			this.rx = rx;
			this.by = by;
			this.bx = bx;
			this.dep = dep;
		}
	}

	static char[][] map;

	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		chk = new boolean[10][10][10][10];
		int ry = 0, rx = 0, by = 0, bx = 0;
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j);
				if (map[i][j] == 'R') {
					ry = i;
					rx = j;
				} else if (map[i][j] == 'B') {
					by = i;
					bx = j;
				}
			}
		}
		Queue<Pos> q = new LinkedList<Pos>();
		q.add(new Pos(ry, rx, by, bx, 0));
		chk[ry][rx][by][bx]=true;
		bfs(q);
	}// main

	private static void bfs(Queue<Pos> q) {

		while (!q.isEmpty()) {
			Pos tmp = q.poll();
			if (tmp.dep >= 10)
				break;

			for (int i = 0; i < 4; i++) {
				int nry = tmp.ry, nrx = tmp.rx, nby = tmp.by, nbx = tmp.bx;
				int rc = 0, bc = 0;
				while (map[nry + dy[i]][nrx + dx[i]] != '#' && map[nry][nrx] != 'O') {
					nry += dy[i];
					nrx += dx[i];
					rc++;
				}
				while (map[nby + dy[i]][nbx + dx[i]] != '#' && map[nby][nbx] != 'O') {
					nby += dy[i];
					nbx += dx[i];
					bc++;
				}
				if (map[nby][nbx] == 'O')
					continue;
				if (map[nry][nrx] == 'O') {
					System.out.println(1);
					return;
				}
				if (nry == nby && nrx == nbx) {
					if (rc < bc) {
						nby -= dy[i];
						nbx -= dx[i];
					} else {
						nry -= dy[i];
						nrx -= dx[i];
					}
				}
				if (chk[nry][nrx][nby][nbx])
					continue;
				chk[nry][nrx][nby][nbx] = true;
				q.add(new Pos(nry, nrx, nby, nbx, tmp.dep+1));
			}
		}//while
		System.out.println(0);
	}
}// class

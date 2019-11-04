import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class SolutionSepo {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, M, K, ans;
	static int[][] map;
	static int[] dy = { 0, 0, 1, -1 }, dx = { 1, -1, 0, 0 };

	static class Pos implements Comparator<Pos>{
		int y, x, size, life;
		
		public Pos() {
			super();
		}

		public Pos(int y, int x, int size, int life) {
			super();
			this.y = y;
			this.x = x;
			this.size = size;
			this.life = life;
		}

		@Override
		public int compare(Pos o1, Pos o2) {
			return o2.life-o1.life;
		}

	}
	static ArrayList<Pos> list;
	public static void main(String[] args) throws Exception {
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine().trim());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			ans = 0;
			map = new int[N+700][M+700];

			list = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					map[i+300][j+300] = Integer.parseInt(st.nextToken());
					if (map[i+300][j+300] > 0)
						list.add(new Pos(i+300, j+300, map[i+300][j+300], map[i+300][j+300]));
				}
			}
			
			solve(map);
//			ans = count(map);
//			print(map);
			System.out.printf("#%d %d\n", t, list.size());
		} // tc

	}// main

//	private static void print(int[][] map) {
//		for (int i = 0; i < N + K; i++) {
//			for (int j = 0; j < N + K; j++) {
//				System.out.print(map[i][j] + " ");
//			}
//			System.out.println();
//		}
//	}

//	private static int count(int[][] map) {
//		int cnt = 0;
//		for (int i = 0; i < N + K; i++) {
//			for (int j = 0; j < N + K; j++) {
//				if (map[i][j] > 0) {
//					cnt++;
//				}
//			}
//		}
//		return cnt;
//	}

	private static void solve(int[][] map) {
		int time = 0;
		while (time < K) {
			// life 큰놈부터 실행
			Collections.sort(list,new Pos());
			// status가 0이면 증식, 아니면 --
			int arrSize=list.size();
			for(int j=0;j<arrSize;j++) {
				if(list.get(j).size!=0) {
					list.get(j).size--;
				}else {
					list.get(j).size--;
					Pos v = list.get(j);
					for(int k=0;k<4;k++) {
						//4방향 증식 중에 room에 증식한 세포가 없으면 증식하고 arr 추가
						if(map[v.y+dy[k]][v.x+dx[k]]==0) {
							list.add(new Pos(v.y+dy[k], v.x+dx[k], v.life, v.life));
							map[v.y+dy[k]][v.x+dx[k]] = v.life;
						}
					}
				}
			}
			// 죽은 세포 제거
			for(int j=arrSize-1;j>=0;j--) {
				//남은 증식 시간보다 활성상태 시간이 짧은 경우 삭제
				if(list.get(j).size < 0 && K-time > list.get(j).life+list.get(j).size) {
					list.remove(j);
				}
			}
			time++;
		} // while
	}

//	private static void bfs(Pos p, ArrayList<Pos> list) {
//		for (int i = 0; i < 4; i++) {
//			int ny = p.y + dy[i];
//			int nx = p.x + dx[i];
//			if (map[ny][nx]==0){
//				list.add(new Pos(ny, nx, p.life, p.life));
//				map[ny][nx] = p.life;
//			}
//		}
//	}

}// class

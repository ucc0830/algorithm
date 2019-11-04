import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SolutionLunch {

	static BufferedReader br;
	static StringTokenizer st;
	static int[] dy = {-1,1,0,0},dx = {0,0,-1,1};
	static class Pos {
		int y, x, s,time;

		public Pos(int y, int x, int s, int time) {
			super();
			this.y = y;
			this.x = x;
			this.s = s;
			this.time = time;
		}
	}
	static class Sta{
		int y,x,h;

		public Sta(int y, int x, int h) {
			super();
			this.y = y;
			this.x = x;
			this.h = h;
		}
	}

	static ArrayList<Sta> sr;
	static int N;

	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			int[][] map = new int[N][N];
			ArrayList<Pos> pp = new ArrayList<>();
			sr = new ArrayList<>();

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] == 1) {
						pp.add(new Pos(i, j, -1,0));
					} else if (map[i][j] >= 2) {
						sr.add(new Sta(i, j, map[i][j]));
					}
				}
			}

			comb(0, 0, pp);// cnt

		} // tc

	}// main

	private static void comb(int idx, int cnt, ArrayList<Pos> pp) {
		if (cnt == pp.size()) {
			for(int i=0;i<pp.size();i++) {
				int toStair = Math.abs(pp.get(i).y - sr.get(pp.get(i).s).y) + Math.abs(pp.get(i).x - sr.get(pp.get(i).s).x);//계단까지 가는 시간
				pp.get(i).time=toStair;
			}
			calc(pp);
			return;
		}

		for (int i = idx; i < pp.size(); i++) {
			pp.get(i).s = 0;// 계단선택
			comb(i + 1, cnt + 1, pp);
			pp.get(i).s = 1;
		}
	}

	private static void calc(ArrayList<Pos> pp) {
		ArrayList<Integer> s = new ArrayList<>();
		ArrayList<Integer> wating = new ArrayList<>();
		int time = 0;
		while(true) {//다 내려갈 때까지
			for(int i=pp.size()-1;i>=0;i--) {
				if(pp.get(i).time==time) {
					if(s.size()<3) {
						s.add(sr.get(pp.get(i).s).h);
						pp.remove(i);
					}
					else {
						wating.add(sr.get(pp.get(i).s).h);
						pp.remove(i);
					}
				}
			}
			
			time++;
		}
		
		

	}

}// class

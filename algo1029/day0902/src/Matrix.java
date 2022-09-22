import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

/*
 * 행렬찾기
 * 1. 0이 아닌 정수가 나오면 0이 나올 때까지 y방향 진행
 * 2. 0이 나오면 같은 방식으로 x방향 진행
 * 3. cntY,cntX 값을 저장
 * 4. 행렬완성
 */
public class Matrix {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static class Mat {
		int y, x, size;

		public Mat() {
		}

		public Mat(int y, int x, int size) {
			super();
			this.y = y;
			this.x = x;
			this.size = size;
		}
		
	}
	static ArrayList<Mat> list = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			list.clear();
			int N = Integer.parseInt(br.readLine());
			int[][] map = new int[N][N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			solve(map, N);
			Collections.sort(list,new Comparator<Mat>() {
				@Override
				public int compare(Mat o1, Mat o2) {
					if(o1.size>o2.size) return 1;
					else if(o1.size<o2.size) return -1;
					else {
						if(o1.y>=o2.y) return 1;
						else return -1;
					}
				}
			});
			
			System.out.print("#" + t+ " " + list.size()+" ");
			for(int i=0;i<list.size();i++) {
				System.out.print(list.get(i).y + " "+list.get(i).x+" ");
			}System.out.println();
		} // testcase

	}// main

	private static void solve(int[][] map, int N) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] != 0) {
					dfs(map, i, j);
				}
			}
		}
	}

	private static void dfs(int[][] map, int y, int x) {
		int cntY = 0, cntX = 0;
		int ny = y,nx=x;
		while (map[ny][nx] != 0) {
			cntY++;
			ny++;
			if(ny>=map.length) break;
		}
		ny--;
		while (map[ny][nx] != 0) {
			cntX++;
			nx++;
			if(nx>=map.length) break;
		}
		nx--;
		for(int i=y;i<y+cntY;i++) {
			for(int j=x;j<x+cntX;j++) {
				map[i][j]=0;
			}
		}
		list.add(new Mat(cntY,cntX,cntY*cntX));
	}

}// class

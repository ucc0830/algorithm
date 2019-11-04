import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 * 미생물격리
 */
public class Solution2 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static class Mic {
		int death, y, x, num, dir;

		public Mic(int death, int y, int x, int num, int dir) {
			this.death = death;
			this.y = y;
			this.x = x;
			this.num = num;
			this.dir = dir;
		}
	}

//	static int[] dy= {0,-1,+1,0,0},dx= {0,0,0,-1,+1};//상하좌우(1,2,3,4)
	static int n, m, k;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; ++t) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			map = new int[n][n];
			int m = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			Mic[] list = new Mic[k];
			ArrayList<ArrayList<Integer>> listt = new ArrayList<ArrayList<Integer>>();

			for (int i = 0; i < k; i++) {
				st = new StringTokenizer(br.readLine());
				int y = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				int num = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken());
				list[i] = new Mic(1, y, x, num, dir);
				map[y][x] = 1;
			} // 미생물입력

			for (int i = 0; i < m; i++) {// m초 동안 수행
				for (int j = 0; j < k; j++) {// k개 군집에 대해 수행
					map[list[j].y][list[j].x] -= 1;
					if (list[j].death == 1) {
						switch (list[j].dir) {
						case 1:
							list[j].y -= 1;
							if (list[j].y == 0) {
								list[j].dir = 2;
								list[j].num /= 2;
							}
							break;
						case 2:
							list[j].y += 1;
							if (list[j].y == n - 1) {
								list[j].dir = 1;
								list[j].num /= 2;
							}
							break;
						case 3:
							list[j].x -= 1;
							if (list[j].x == 0) {
								list[j].dir = 4;
								list[j].num /= 2;
							}
							break;
						case 4:
							list[j].x += 1;
							if (list[j].x == n - 1) {
								list[j].dir = 3;
								list[j].num /= 2;
							}
							break;
						}
					} // if
					map[list[j].y][list[j].x] += 1;
				} // for(군집수)
				for (int p = 0; p < n; p++) {
					for (int q = 0; q < n; q++) {
						int size = map[p][q];
						if (size > 1) {
							int[] values = new int[size];
							int now = 0;
							int max = -1;
							for (int r = 0; r < k; r++) {
								if (list[r].death == 1 && list[r].y == p && list[r].x == q) {
									values[now] = r;
									now++;
									if (max == -1) {
//										System.out.println("rrrrrrrrrrrrrr  ==> " + r);
										max = r;
//										System.out.println("maxxxxxxxxxxx1  ==> " + max);
									} else if (list[max].num < list[r].num) {
										max = r;
//										System.out.println("maxxxxxxxxxxx2  ==> " + max);
									}
								}
							}
//							System.out.println(max+" -----");
							for (int r = 0; r < size; r++) {
								int nowVal = values[r];
								if (nowVal != max && list[nowVal].death == 1) {
									list[nowVal].death = 0;
//									System.out.println(max + ", " + nowVal+", "+r);
									list[max].num += list[nowVal].num;
								}
							}
							map[p][q] = 1;
						} // if
					}
				}

			} // for(m)
			int rst = 0;
			for (int i = 0; i < k; i++) {
				if (list[i].death == 1) {
					rst += list[i].num;
				}
			}
			System.out.printf("#%d %d\n", t, rst);
		} // testcase
	}// main

}// class

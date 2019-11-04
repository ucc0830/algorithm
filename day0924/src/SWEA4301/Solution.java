package SWEA4301;

import java.util.Scanner;
/*
 * 콩 많이 심기
 * 그리디적인 해법을 사용한다
 * 처음 위치부터 거리가 2인 모든 위치를 삭제해서 남은 콩의 개수를 출력한다.
 */
public class Solution {
	static int[] dy = { 0, 2 }, dx = { 2, 0 };
	static int n, m;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			m = sc.nextInt();
			n = sc.nextInt();
			int[][] arr = new int[n][m];
			int ans = m * n;

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (arr[i][j] > 0)
						continue;
					for (int z = 0; z < 2; z++) {
						int ni = i + dy[z];
						int nj = j + dx[z];
						if (ni < 0 || nj < 0 || ni >= n || nj >= m||arr[ni][nj] > 0)
							continue;
						arr[ni][nj]=1;
						ans--;
					}
				}
			}
			System.out.printf("#%d %d\n", t, ans);
		} // tc
	}// main

//	private static int func() {
//		int rst = 0;
//		ArrayList<Pos> list = new ArrayList<>();
//		for (int i = 0; i < n; i++) {
//			for (int j = 0; j < m; j++) {
//				boolean flag = true;
//				k: for (int k = 0; k < list.size(); k++) {
//					int dist = (int) Math
//							.sqrt((double) (Math.pow(list.get(k).y - i, 2) + Math.pow(list.get(k).x - j, 2)));
//					if (dist == 2) {
//						flag = false;
//						break k;
//					}
//				}
//				if(flag) {
//					System.out.println("add : "+i+", "+j);
//					list.add(new Pos(i, j));
//				}
//				rst = Math.max(list.size(), rst);
//			}
//		}
//		return rst;
//	}
}

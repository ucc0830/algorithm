package BOJ2630;

import java.util.Scanner;

public class Main {
	static int[] cnt;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] arr = new int[n][n];
		cnt = new int[2];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		int off = arr[0][0];
		dfs(off, arr, 0, 0, n, n);
		System.out.println(cnt[0]);
		System.out.println(cnt[1]);
	}

	private static void dfs(int off, int[][] arr, int sy, int sx, int w, int h) {
		System.out.println(sy+", "+sx+" ||||| "+h+", "+w);
		for (int i = sy; i < h; i++) {
			for (int j = sx; j < w; j++) {
				if (arr[i][j] != off) {
					System.out.println(i+", "+j);
					dfs(arr[sy][sx], arr, 0, 0, w / 2, h / 2);
					dfs(arr[sy][sx+w/2], arr, 0, w / 2, w, h / 2);
					dfs(arr[sy+h/2][sx], arr, h / 2, 0, w / 2, h);
					dfs(arr[sy+h/2][sx+w/2], arr, h / 2, w / 2, w, h);
					return;
				}
			}
		}
		cnt[off]++;
		return;
	}
}

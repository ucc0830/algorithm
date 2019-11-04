package BOJ2630;
import java.util.Scanner;

public class Main1 {
	static int[] cnt;
	static int[][] arr;
	static int cn;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		arr = new int[n][n];
		cnt = new int[2];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		dfs(0, 0, n);
		System.out.println(cnt[0]);
		System.out.println(cnt[1]);
		System.out.println(cn);
	}

	private static void dfs(int sy, int sx, int n) {
		cn++;
		int off = arr[sy][sx];
		for (int i = sy; i < sy+n; i++) {
			for (int j = sx; j < sx+n; j++) {
				if (off != arr[i][j]) {
					dfs(sy, sx, n/2);
					dfs(sy, sx+n/2, n/2);
					dfs(sy+n/2, sx, n/2);
					dfs(sy+n/2, sx+n/2, n/2);
					return;
				}
			}
		}
		cnt[off]++;
		return;
	}
}


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main_1024 {

	static int M;
	static int N;
	static int[][] map;
	static boolean[][] visited;

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int[][] memo;

	static int cnt = 0;
	static int dfs(int r, int c) {
		if (r == M-1 && c == N-1)
			return 1;
		if (memo[r][c] != 0)
			return memo[r][c];
		if(!visited[r][c]) {
			visited[r][c] = true;
			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if (nr < 0 || nc < 0 || nr >= M || nc >= N)
					continue;
				if (map[nr][nc] < map[r][c]) {
					memo[r][c] += dfs(nr, nc);
				}
			}
		}
		return memo[r][c];
	}

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		N = sc.nextInt();
		map = new int[M][N];
		memo = new int[M][N];
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++)
				map[i][j] = sc.nextInt();
		}
		visited = new boolean[M][N];
		int result = dfs(0,0);
		System.out.println(result);
	}

}

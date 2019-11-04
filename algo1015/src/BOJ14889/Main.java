package BOJ14889;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static boolean[] visited;
	static int[][] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		arr = new int[N + 1][N + 1];
		visited = new boolean[N + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		selectTeam(1, 0);
		System.out.println(min);

	}

	static int min = 100000;

	private static void selectTeam(int idx, int cnt) {
		if (cnt >= N / 2) {
			int temp = calc();
			min = min > temp ? temp : min;
			return;
		}

		for (int i = idx; i <= N; i++) {
			visited[i] = true;
			selectTeam(i + 1, cnt + 1);
			visited[i] = false;
		}

	}

	private static int calc() {
		int aScore = 0;
		int bScore = 0;

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (visited[i] && visited[j])
					aScore += arr[i][j];
				if (!visited[i] && !visited[j])
					bScore += arr[i][j];
			}
		}
//		System.out.println("a : " + aScore + ", b : "+ bScore);
//		System.out.println(" diff : " + Math.abs(aScore - bScore));
		return Math.abs(aScore - bScore);
	}

}

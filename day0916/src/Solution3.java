import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * dijkstra Algorithm
 * 1263. 사람 네트워크2
 */
public class Solution3 {

	static BufferedReader br;
	static StringTokenizer st;
	static int N;
	static int INF = Integer.MAX_VALUE;
	static int[] d;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			int[][] arr = new int[N][N];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					if (i != j && arr[i][j] == 0)
						arr[i][j] = INF;
				}
			}


			int ans = INF;
			for (int i = 0; i < N; i++) {
				d = new int[N];
				visited = new boolean[N];
				ans = Math.min(ans, dijkstra(i, arr));
			}
			System.out.printf("#%d %d\n", t, ans);
		}

	}

	private static int dijkstra(int s, int[][] arr) {

		for (int i = 0; i < N; i++) {
			d[i] = INF;
		}

		d[s] = 0;
		visited[s] = true;

		for (int i = 0; i < N; i++) {
			if (!visited[i] && arr[s][i] != INF) {
				d[i] = arr[s][i];
			}
		}

		for (int i = 0; i < N - 1; i++) {

			int minVal = INF;
			int minIdx = -1;

			for (int j = 0; j < N; j++) {
				if (!visited[j] && d[j] != INF) {
					if (minVal > d[j]) {
						minVal = d[j];
						minIdx = j;
					}
				}
			}
			
			visited[minIdx] = true;
			
			for (int j = 0; j < N; j++) {
				if (!visited[j] && arr[minIdx][j] != INF) {
					if (d[j] > d[minIdx] + arr[minIdx][j]) {
						d[j] = d[minIdx] + arr[minIdx][j];
					}
				}
			}

		} // for(i)
		int sum = 0;
		for (int i = 0; i < N; i++) {
			sum += d[i];
		}
		return sum;
	}// dijkstra

}

package JUNGOL1681;

import java.util.Scanner;

/*
 * 해밀턴 순환회로
 */
public class Main {
	static int N;
	static int[][] map;
	static boolean[] visited;
	static int money = Integer.MAX_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		map = new int[N][N];
		visited = new boolean[N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		DFS(1, 0, 0); // cnt, 위치, 돈
		System.out.println(money);
	}

	private static void DFS(int cnt, int location, int price) {

		if (cnt == N) {
			if (map[location][0] != 0) { // 집으로 돌아가는 경로의 돈이 0이면 갈 수 없다.
				if (price + map[location][0] < money)
					money = price + map[location][0]; // 마지막 경로 + price한게 money보다 작으면 더 적응 비용 드는것이다.
			}

			return;
		}
		for (int i = 1; i < N; i++) { // 0인 부분은 다시 집으로 돌아 올때 !! 1부터 시작하기.
			if (visited[i] == false && map[location][i] != 0) {
				if (map[location][i] + price < money) {// 누적비용이 작을때만 실행하기.
					visited[location] = true;
					DFS(cnt + 1, i, map[location][i] + price); // 비용은 누적하여 넘겨 주기
					visited[i] = false;
				}
			}
		}

	}
}
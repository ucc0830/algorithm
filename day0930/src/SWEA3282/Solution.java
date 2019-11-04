package SWEA3282;

import java.util.Scanner;

public class Solution {
	static int[][] items;
	static int N, capacity;
	static int K[][];
	static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			capacity = sc.nextInt();
			items = new int[N+1][2];//부피 0, 가치 1
			K = new int[N+1][capacity+1];

			for (int i = 1; i <= N; i++) {
				for (int j = 0; j < 2; j++) {
					items[i][j] = sc.nextInt();
				}
			}
			
			for (int i = 1; i <= N; i++) {
				for (int w = 1; w <= capacity; w++) { // W는 각각의 무게 ,가방무게
					if (items[i][0] > w) {
						K[i][w] = K[i - 1][w];
					} else {
						K[i][w] = Math.max(K[i - 1][w], K[i - 1][w - items[i][0]] + items[i][1]);
					}
				}
			}
			System.out.printf("#%d %d%n", t, K[N][capacity]);

		}
	}
}
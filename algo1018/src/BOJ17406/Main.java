package BOJ17406;

import java.util.Scanner;

public class Main {
	static class magic {
		int y, x, s;

		public magic(int y, int x, int s) {
			super();
			this.y = y;
			this.x = x;
			this.s = s;
		}
	}

	static int n, m, k, ans;
	static int[][] arr,copy;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		k = sc.nextInt();
		ans = Integer.MAX_VALUE;
		arr = new int[n][m];
		copy = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		for(int i=0;i<n;i++) {
			copy[i]=arr[i].clone();
		}
		magic[] list = new magic[k];
		for (int i = 0; i < k; i++) {
			list[i] = new magic(sc.nextInt() - 1, sc.nextInt() - 1, sc.nextInt());
		}
		permu(0, list, k);
		System.out.println(ans);
	}

	private static void permu(int idx, magic[] list, int siz) {
		if (idx == siz) {
			for(int i=0;i<n;i++) {
				arr[i]=copy[i].clone();
			}
//			print(list);
			rotate(list);
//			System.out.println();
//			print(arr);
			ans = Math.min(ans, calc(arr, n, m));
		}
		for (int i = idx; i < siz; i++) {
			swap(list, i, idx);
			permu(idx + 1, list, siz);
			swap(list, i, idx);
		}

	}

	private static void print(int[][] arr) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static void print(magic[] list) {
		for (int i = 0; i < list.length; i++) {
			System.out.println(list[i].y + ", " + list[i].x);
		}
		System.out.println();
	}

	private static void swap(magic[] list, int a, int b) {
		magic tmp = list[a];
		list[a] = list[b];
		list[b] = tmp;
	}

	private static int calc(int[][] arr, int n, int m) {
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			int sum = 0;
			for (int j = 0; j < m; j++) {
				sum += arr[i][j];
			}
			min = Math.min(sum, min);
		}
		return min;
	}

	private static void rotate(magic[] list) {
		for (int j = 0; j < list.length; j++) {
			for (int i = 1; i <= list[j].s; i++) {
				int tmp = arr[list[j].y - i][list[j].x + i];// 맨 위 오른쪽 끝 숫자

				for (int x = list[j].x + i; x > list[j].x - i; x--) {// 윗줄 오른쪽으로
					arr[list[j].y - i][x] = arr[list[j].y - i][x - 1];
				}
				
				for (int y = list[j].y - i; y < list[j].y + i; y++) {// 왼쪽줄 위로
					arr[y][list[j].x - i] = arr[y + 1][list[j].x - i];
				}
				
				for (int x = list[j].x - i; x < list[j].x + i; x++) {// 밑줄 왼쪽으로
					arr[list[j].y + i][x] = arr[list[j].y + i][x + 1];
				}
				
				for (int y = list[j].y + i; y > list[j].y - i + 1; y--) {// 오른쪽 밑으로
					arr[y][list[j].x + i] = arr[y - 1][list[j].x + i];
				}
				arr[list[j].y-i+1][list[j].x + i] = tmp;
			} // size만큼 돈다
		}
	}

}

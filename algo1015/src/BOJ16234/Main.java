package BOJ16234;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int N, L, R;
	static int[] dy = { 0, 0, 1, -1 }, dx = { 1, -1, 0, 0 };
	static int[][] arr, copyarr;
	static boolean f2;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		L = sc.nextInt();
		R = sc.nextInt();
		arr = new int[N][N];
		copyarr = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		int ans = 0;
		while (true) {
			boolean[][] visited = new boolean[N][N];
			f2=false;
//			copy(copyarr, arr);
			for (int i = 0; i < N; i++) {// 모든 좌표에 대해
				for (int j = 0; j < N; j++) {
					if (!visited[i][j]) {
						func(i, j, visited);
					}
				}
			}
//			copy(arr, copyarr);
//			print(arr);
			if (!f2)
				break;
			ans++;
		}
		System.out.println(ans);
	}

	private static void print(int[][] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				System.out.print(a[i][j] + " ");
			}	
			System.out.println();
		}
		System.out.println();
	}

	private static void func(int y, int x, boolean[][] visited) {
		ArrayList<int[]> list = new ArrayList<>();
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] { y, x });
		list.add(new int[] { y, x, arr[y][x] });
		visited[y][x]=true;
		
		while (!q.isEmpty()) {
			int[] t = q.poll();
			for (int z = 0; z < 4; z++) {
				int ny = t[0] + dy[z];
				int nx = t[1] + dx[z];
				if (ny < 0 || nx < 0 || ny >= N || nx >= N || visited[ny][nx])
					continue;
				int diff = Math.abs(arr[ny][nx] - arr[t[0]][t[1]]);
				if (diff >= L && diff <= R) {
					visited[ny][nx]=true;
					q.add(new int[] {ny,nx});
					list.add(new int[] { ny, nx, arr[ny][nx] });
				}
			}
		} // 국경선 공유지역 list에 담기
		if(list.size()>1) {
			f2=true;
		}
		int sum = 0;
		for (int i = 0; i < list.size(); i++) {
			int[] t = list.get(i);
			arr[t[0]][t[1]] = 0;
			sum += t[2];
		}
		sum /= list.size();
		for (int i = 0; i < list.size(); i++) {
			int[] t = list.get(i);
			arr[t[0]][t[1]] += sum;
		}
	}

	private static void copy(int[][] arr, int[][] brr) {
		for (int i = 0; i < arr.length; i++) {
			arr[i] = brr[i].clone();
		}
	}

}

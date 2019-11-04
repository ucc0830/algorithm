package BOJ16235;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	static class tree {
		int y, x, age;

		public tree(int y, int x, int age) {
			super();
			this.x = x;
			this.y = y;
			this.age = age;
		}

	}

	static int N, M, K;
	static int[] dy = { -1, -1, -1, 0, 0, 1, 1, 1 }, dx = { -1, 0, 1, -1, 1, -1, 0, 1 };// 인접한 8방향

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();

		int[][] addNut = new int[N][N];// 겨울에 추가되는 양분
		int[][] initNut = new int[N][N];// 초기 양분
		for (int[] a : initNut) {
			Arrays.fill(a, 5);
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				addNut[i][j] = sc.nextInt();
			}
		}

		Deque<tree> trees = new ArrayDeque<>();
		Deque<tree> death = new ArrayDeque<>();
		Deque<tree> spread = new ArrayDeque<>();
		for (int i = 0; i < M; i++) {
			trees.add(new tree(sc.nextInt() - 1, sc.nextInt() - 1, sc.nextInt()));
		}

		int time = 0;
		while (time < K) {
			// 봄
			
			int size = trees.size();
			while(size > 0) {
				size--;
				tree t = trees.removeFirst();
				
				if(initNut[t.y][t.x] < t.age) {
					death.push(t);
					continue;
				}				
				
				initNut[t.y][t.x] -= t.age;
				t.age += 1;
				trees.addLast(t);
				
				if(t.age%5 == 0)
					spread.push(t);
			}
			
//			for (int i = 0; i < trees.size(); i++) {
//				tree t = trees.get(i);
//				if (initNut[t.y][t.x] >= t.age) {// 먹을 수 있으면 먹고
//					initNut[t.y][t.x] -= t.age;
//					t.age++;
//					if (t.age % 5 == 0)
//						spread.add(t);
//				} else {
//					death.add(t);
//					trees.remove(i);i--;
//				}
//			}
			// 여름
			while (!death.isEmpty()) {
				tree t = death.poll();
				initNut[t.y][t.x] += t.age / 2;
			}
			// 가을
			while (!spread.isEmpty()) {
				tree t = spread.poll();
				for (int z = 0; z < 8; z++) {
					int ny = t.y + dy[z];
					int nx = t.x + dx[z];
					if (ny < 0 || nx < 0 || ny >= N || nx >= N)
						continue;
					trees.addFirst(new tree(ny, nx, 1));
				}
			}
			// 겨울
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					initNut[i][j] += addNut[i][j];
				}
			}
			time++;
		}
		System.out.println(trees.size());
	}
}

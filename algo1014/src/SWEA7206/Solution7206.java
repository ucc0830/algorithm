package SWEA7206;

import java.util.Arrays;
import java.util.Scanner;

/*
 * 2019-10-14 알고리즘 문제풀이
 * SWEA #7206 숫자 게임 (User Problem)
 * 29/50
 */
public class Solution7206 {
	static int turn = 0;
	// static boolean[] visited;
	static int[] ary;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		for (int tc = 1; tc <= t; tc++) {
			int n = sc.nextInt();
			int answer = 0;
			ary = new int[n + 1];
			turn = 0;
			if (n >= 10) {
				int k = (int) Math.log10(n) + 1; // 자리수
				boolean[] visited = new boolean[k];
				comb(n, k, 1, 0, 0, visited);
				// recur(n,k,0);

				answer = turn;
			}
			System.out.println("#" + tc + " " + answer);
		}

	}

	static void comb(int n, int k, int depth, int how, int cnt, boolean[] visited) {
		if (n < 10) {
			recur(n, k, how, cnt, visited);
			return;
		}
		if (k == depth) {
			if (how == 0) {
				return;
			}
			recur(n, k, how, cnt, visited);
			return;
		}

		visited[depth] = true;
		comb(n, k, depth + 1, how + 1, cnt, visited);

		visited[depth] = false;
		comb(n, k, depth + 1, how, cnt, visited);
	}

	static void recur(int n, int k, int how, int cnt, boolean[] visited) {
		if (n < 10) {// 1의 자리수
			turn = Math.max(turn, cnt);
			return;
		}
		if (ary[n] > cnt) {
			return;
		}

		int[] cut = new int[how + 1];
		int idx = k - 1;
		int c = 0;
		int p = (int) Math.pow(10, idx);
		cut[c] = n;
		// System.out.println(n+" "+k+" "+how+" "+cnt);
		while (idx > 0) {
			if (visited[idx]) {
				p = (int) Math.pow(10, idx);
				int t = cut[c];
				cut[c] = t / p;
				cut[c + 1] = t % p;
				c++;
			}
			idx--;
		}
		int nn = 1;
		for (int i = 0; i < how + 1; i++) {
			nn *= cut[i];
		}
		// System.out.println(nn);
		// Arrays.fill(visited, false);
		ary[nn] = Math.max(ary[nn], cnt);
		boolean[] newv = new boolean[nn == 0 ? 1 : (int) Math.log10(nn) + 1];
		comb(nn, nn == 0 ? 1 : (int) Math.log10(nn) + 1, 1, 0, cnt + 1, newv);
	}

}

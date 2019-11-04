package stylelish;

import java.util.Scanner;

public class Solution {

	static char[][] master, me;
	static int p, q;
	static int[] ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		tc: for (int t = 1; t <= T; t++) {
			p = sc.nextInt();
			q = sc.nextInt();
			master = new char[p][];
			me = new char[q][];

			for (int i = 0; i < p; i++) {
				master[i] = sc.next().toCharArray();
			}
			for (int i = 0; i < q; i++) {
				me[i] = sc.next().toCharArray();
			}

			ans = new int[q];
			for (int r = 1; r <= 20; r++) {
				for (int c = 1; c <= 20; c++) {
					for (int s = 1; s <= 20; s++) {
//						System.out.print(r + " " + c + " " + s + ", ");
//						System.out.println(isAvaliable(r, c, s));
						if (isAvaliable(r, c, s)) {
							ans = processIndent(r, c, s);
						}
					}
				}
			}
			System.out.printf("#%d ", t);
			for (int i = 0; i < ans.length; i++) {
				System.out.print(ans[i] + " ");
			}
			System.out.println();
		} // tc

	}// main

	private static int[] processIndent(int r, int c, int s) {
		int rr = 0;
		int cc = 0;
		int ss = 0;
		for (int i = 0; i < q; i++) {
			int tmp = rr * r + cc * c + ss * s;

			if (ans[i] == 0 || ans[i] == tmp) {
				ans[i] = tmp;
			} else {
				ans[i] = -1;
			}

			for (int j = 0; j < me[i].length; j++) {

				if (me[i][j] == '(') {
					rr++;
				} else if (me[i][j] == '{') {
					cc++;
				} else if (me[i][j] == '[') {
					ss++;
				} else if (me[i][j] == ')') {
					rr--;
				} else if (me[i][j] == '}') {
					cc--;
				} else if (me[i][j] == ']') {
					ss--;
				}
			}
		}
		return ans;
	}

	private static boolean isAvaliable(int r, int c, int s) {
		int rr = 0;
		int cc = 0;
		int ss = 0;
		for (int i = 0; i < p; i++) {
			int cnt = 0;
			for (char ch : master[i]) {
				if (ch == '.') {
					cnt++;
				} else
					break;
			}

			int tmp = rr * r + cc * c + ss * s;
			if (cnt != tmp) {
				return false;
			}

			for (char ch : master[i]) {
				if (ch == '(') {
					rr++;
				} else if (ch == '{') {
					cc++;
				} else if (ch == '[') {
					ss++;
				} else if (ch == ')') {
					rr--;
				} else if (ch == '}') {
					cc--;
				} else if (ch == ']') {
					ss--;
				}
			}
		}
		return true;
	}

}// class

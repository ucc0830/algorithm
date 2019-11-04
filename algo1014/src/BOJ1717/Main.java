package BOJ1717;

import java.util.Scanner;

public class Main {
	static int n, m;
	static int[] p;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		p = new int[n + 1];
		makeSet();
		for (int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			if (a == 0) {
				unionSet(b, c);
			} else {
				if (findSet(b) == findSet(c)) {
					System.out.println("YES");
				} else {
					System.out.println("NO");
				}
			}
		}

	}

	static void makeSet() {
		for (int i = 1; i <= n; i++) {
			p[i] = i;
		}
	}

	static int findSet(int x) {
		if (x == p[x])
			return x;
		p[x] = findSet(p[x]);
		return p[x];
	}

	static void unionSet(int n1, int n2) {
		int py = findSet(n1);
		int px = findSet(n2);
		if (py == px) {
			return;
		}
		p[py] = px;
	}

}

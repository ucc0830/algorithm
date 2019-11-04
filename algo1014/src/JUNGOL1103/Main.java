package JUNGOL1103;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static class pos {
		int f, s;
		public pos(int f, int s) {
			super();
			this.f = f;
			this.s = s;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		int k = sc.nextInt();
		ArrayList<pos> list = new ArrayList<>();
		int[] dist = new int[k];

		for (int i = 0; i < k; i++) {
			int f = sc.nextInt();
			int s = sc.nextInt();
			list.add(new pos(f, s));
		}
		pos dong = new pos(sc.nextInt(), sc.nextInt());

		for (int i = 0; i < k; i++) {
			int s1 = dong.s;
			int s2 = list.get(i).s;

			if (dong.f == list.get(i).f) {
				dist[i] = Math.abs(dong.s - list.get(i).s);
			} else {
				switch (dong.f) {
				case 1:
					switch (list.get(i).f) {
					case 2:
						dist[i] = n + Math.min(s1 + s2, 2 * n - (s1 + s2));
						break;
					case 3:
						dist[i] = s1 + s2;
						break;
					case 4:
						dist[i] = m - s1 + s2;
						break;
					}
					break;
				case 2:
					switch (list.get(i).f) {
					case 1:
						dist[i] = n + Math.min(s1 + s2, 2 * m - (s1 + s2));
						break;
					case 3:
						dist[i] = s1 + n - s2;
						break;
					case 4:
						dist[i] = n + m - s1 - s2;
						break;
					}
					break;
				case 3:
					switch (list.get(i).f) {
					case 1:
						dist[i] = s1 + s2;
						break;
					case 2:
						dist[i] = n - s1 + s2;
						break;
					case 4:
						dist[i] = m + Math.min(s1 + s2, 2 * n - (s1 + s2));
						break;
					}
					break;
				case 4:
					switch (list.get(i).f) {
					case 1:
						dist[i] = m - s2 + s1;
						break;
					case 2:
						dist[i] = n + m - s1 - s2;
						break;
					case 3:
						dist[i] = m + Math.min(s1 + s2, 2 * n - (s1 + s2));
						break;
					}
					break;
				}
			}
		}

		int sum = 0;
		for (int i = 0; i < dist.length; i++) {
			sum += dist[i];
		}
		System.out.println(sum);

	}
}

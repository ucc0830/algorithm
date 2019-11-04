import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class SolutionHunter {
	static class Pos implements Comparable<Pos> {
		int y, x;

		public Pos(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}

		@Override
		public int compareTo(Pos o) {
			return this.x - o.x;
		}

	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt();
		int L = sc.nextInt();

		ArrayList<Integer> huntList = new ArrayList<>();
		ArrayList<Pos> aniList = new ArrayList<>();

		for (int i = 0; i < M; i++) {
			huntList.add(sc.nextInt());
		}
		for (int i = 0; i < N; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			if (y > L)
				continue;
			aniList.add(new Pos(y, x));
		}
		N = aniList.size();
		Collections.sort(aniList);
		Collections.sort(huntList);
		System.out.println(solve(M, N, L, huntList, aniList));

	}

	private static int solve(int m, int n, int l, ArrayList<Integer> huntList, ArrayList<Pos> aniList) {
		int xIdx = 0;
		int res = 0;
		for (int i = 0; i < n; i++) {
			while (xIdx < m-1 && huntList.get(xIdx+1) < aniList.get(i).x) {
				xIdx++;
			}
			if (calc(aniList.get(i).y, aniList.get(i).x, huntList.get(xIdx)) <= l) {
				res++;
				continue;
			}
			if (xIdx < m - 1) {
				if (calc(aniList.get(i).y, aniList.get(i).x, huntList.get(xIdx + 1)) <= l) {
					res++;
					continue;
				}
			}
		}//for
		return res;
	}

	private static int calc(int ay, int ax, int hx) {
		return Math.abs(hx - ax) + ay;
	}
}

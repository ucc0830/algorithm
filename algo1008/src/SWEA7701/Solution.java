package SWEA7701;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int n = sc.nextInt();
			Set<String> set = new TreeSet<>(new Comparator<String>() {

				@Override
				public int compare(String o1, String o2) {
					int len = o1.length() - o2.length();
					if (len == 0) {
						return o1.compareTo(o2);
					} else {
						return len;
					}
				}

			});
			for (int i = 0; i < n; i++) {
				set.add(sc.next());
			}
			Iterator<String> it = set.iterator();
			System.out.printf("#%d\n", t);
			while (it.hasNext()) {
				System.out.println(it.next());
			}

		}

	}

}
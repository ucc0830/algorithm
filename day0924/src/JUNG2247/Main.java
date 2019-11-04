package JUNG2247;
/*
 * 도서관 문제
 * 그리디적인 접근으로 학생들이 머무는 시간을 갱신한다
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
	static class Pos {
		int s, e;

		public Pos(int s, int e) {
			super();
			this.s = s;
			this.e = e;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Pos[] input = new Pos[n];
		for (int i = 0; i < n; i++) {
			input[i] = new Pos(sc.nextInt(), sc.nextInt());
		}
		Arrays.sort(input, new Comparator<Pos>() {
			@Override
			public int compare(Pos o1, Pos o2) {
				int rst = o1.s - o2.s;
				return rst;
			}
		});
		ArrayList<Pos> list = new ArrayList<>();
		list.add(input[0]);
		i: for (int i = 1; i < n; i++) {
			Pos in = input[i];
			for (int j = 0; j < list.size(); j++) {
				Pos lis = list.get(j);
				if (in.s <= lis.e) {
					if (in.e > lis.e) {
						list.get(j).e = in.e;
					}
					continue i;
				}
			}//for(j)
			list.add(in);
		}//for(i)
		int inMax = 0;
		for(int i=0;i<list.size();i++) {
			inMax = Math.max(inMax, list.get(i).e-list.get(i).s);
		}
		int emptyMax = 0;
		for(int i=1;i<list.size();i++) {
			emptyMax = Math.max(emptyMax, list.get(i).s-list.get(i-1).e);
		}
		System.out.println(inMax+" "+emptyMax);
		
	}// main
}// class

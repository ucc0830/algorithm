package BOJ16916;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] a = sc.next().toCharArray();
		char[] b = sc.next().toCharArray();

		int[] idx = new int[b.length];
		idx[0] = 0;
		int j = 0;
		for (int i = 1; i < b.length; i++) {
			while (j > 0 && b[i] != b[j]) {
				j = idx[j - 1];
			}
			// 불일치가 일어날 경우
			if (b[i] == b[j]) {
				idx[i] = ++j;
			}
		}
		System.out.println(Arrays.toString(idx));
		ArrayList<Integer> list = new ArrayList<>();
		int ans = 0;
		j = 0;
		for (int i = 0; i < a.length; i++) {
			while (j > 0 && a[i] != b[j]) // 현재 j만큼 찾았는데 이번에 비교하는 문자가 다른 경우
				j = idx[j - 1]; // 문자열 B를 failure function 이후 부터 비교를 해줍니다.
			if (a[i] == b[j]) { // 비교하는 문자가 같은 경우
				if (j == b.length - 1) { // 문자열 B를 전부 탐색하였기 때문에 답에 위치를 넣어줍니다.
					ans=1;
					j = idx[j]; // 다음 탐색을 위하여 이번에도 failure function 이후 부터 비교를 해줍니다.
				} else
					j++; // 문자열 B의 다음 단어를 비교해줍니다.
			}
		}
		System.out.println(ans);
		

//		for(int i=0;i<a.length;i++) {
//			for(int j=0;j<b.length;j++) {
//				if(a[i]==b[i]) {
//					cnt++;
//					idx[i]=0;
//				}else {
//					
//				}
//			}
//		}

	}

}

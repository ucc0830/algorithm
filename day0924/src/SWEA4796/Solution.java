package SWEA4796;
/*
 * 의석이의 우뚝 선 산
 * 숫자가 커지다가 피크를 찍고 내려오는 부분의 개수를 출력해야하는 문제
 * 올라가는 경우와 내려가는 경우를 세서 두 수의 곱을 하면 경우의 수가 나온다.
 * 경우의 수를 누적하여 결과 값을 생성한다.
 */
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {

			int n = sc.nextInt();
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}

			int uCnt = 0, dCnt = 0, ans = 0;
			for (int i = 1; i < n; i++) {
				if (arr[i - 1] < arr[i]) {
					if (dCnt != 0) {
						ans += uCnt * dCnt;
						uCnt = 1;
						dCnt = 0;
						continue;
					}
					uCnt++;
				}
				if (arr[i - 1] > arr[i]) {
					dCnt++;
				}
			}
			ans += uCnt * dCnt;
			System.out.printf("#%d %d\n", t, ans);
		} // tc

	}// main

}// class

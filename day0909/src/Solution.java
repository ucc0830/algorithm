import java.util.Scanner;
//활주로건설
public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int X = sc.nextInt();
			int[][] map = new int[N][N];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			int rst = 0;
			boolean flag;
			int cnt;
			
			for (int i = 0; i < N; i++) {// 가로검사
				flag = false;
				cnt = 1;
				for (int j = 1; j <= N; j++) {
					if (j == N) {
						if (flag){
							if (cnt < X) break;
							rst++;
							break;
						}
						else {
							rst++;
							break;
						}
					}
					
					int prev = map[i][j-1];
					if (map[i][j] <= prev - 2 || map[i][j] >= prev + 2)	break;//높이 2 차이
					
					if (map[i][j] == prev){
						cnt++; continue;
					}
					
					else {
						if (map[i][j] == prev + 1) {//높아진 경우
							if(flag){
								if (cnt < X * 2) break;
								else{
									flag = false;
									cnt = 1;
									continue;
								}
							}
							else if (cnt < X) break;
							else {
								cnt = 1;
								continue;
							}
						}
						else if (map[i][j] == prev - 1) {//낮아진 경우
							if (flag)
								if (cnt < X) break;
							flag = true;
							cnt = 1;
							continue;
						}
					}
				} // for(in)
			} // for(out)
			
			for (int j = 0; j < N; j++) {
				flag = false; cnt = 1;
				for (int i = 1; i <= N; i++) {
					if (i == N) {
						if (flag) {
							if (cnt < X) break;
							rst++;
							break;
						}
						else {
							rst++;
							break;
						}
					}
					int prev = map[i-1][j];
					if (map[i][j] <= prev - 2 || map[i][j] >= prev + 2)	break;
					if (map[i][j] == prev) {
						cnt++; continue;
					}
					else {
						if (map[i][j] > prev) {
							if (flag) {
								if (cnt < X * 2) break;
								else {
									flag = false;
									cnt = 1;
									continue;
								}
							}
							else if (cnt < X) break;
							else {
								cnt = 1;
								continue;
							}
						}
						else if (map[i][j] < prev) {
							if (flag)
								if (cnt < X) break;
							flag = true;
							cnt = 1;
							continue;
						}
					}
				}
			}
			System.out.printf("#%d %d\n",t,rst);
		} // tc

	}// main

}// class

package film;

import java.io.BufferedReader;
import java.util.StringTokenizer;

public class Solution {

	static BufferedReader br;
	static StringTokenizer st;
	static int D, W, K;

	public static void main(String[] args) throws Exception {
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			int[][] arr = new int[D][W];
			
			for(int i=0;i<D;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<W;j++) {
					arr[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			solve(arr);
		}

	}

	private static void solve(int[][] arr) {
		perfomCheck(arr);
		permu(arr);
	}

	private static void permu(int[][] arr) {
		
	}

	private static boolean perfomCheck(int[][] arr) {
		int cnt = 0;
		int chk = 0;
		for(int i=0;i<W;i++) {
			for(int j=0;j<D-1;j++) {
				if(arr[i][j]==chk)
					cnt++;
				else {
				}
				
			}
		}
		return false;
	}

}

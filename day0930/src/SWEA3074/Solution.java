package SWEA3074;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T= sc.nextInt();
		for(int t=1;t<=T;t++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[] tk = new int[n];

			long end = 0;
			for(int i=0;i<n;i++) {
				tk[i]=sc.nextInt();
				end = Math.max(end, tk[i]);
			}
			end = end * (long)m;//최대 처리시간 
			long start = 0; 
			while(start<=end) {
				//전체 시간을 각 창구 처리시간으로 나눈다 -> 그 창구에서 처리한 사람 수 도출
				long person = 0;
				long mid = (start + end)/2;
				for(int i=0;i<n;i++) {
					person += (mid / tk[i]);
				}
				if(person<m) {
					start = mid+1;
				}else {
					end=mid-1;
				}
			}//while
			System.out.printf("#%d %d%n",t,start);
		}//tc
	}//main
}//class

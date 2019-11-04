package SWEA8500;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1;t<=T;t++) {
			int n = sc.nextInt();
			int[] arr = new int[n];
			for(int i=0;i<n;i++) {
				arr[i]=sc.nextInt();
			}
			Arrays.sort(arr);
			int ans = 0;
			ans+=arr[n-1];
			for(int i=0;i<n;i++) {
				ans+=arr[i];
			}
			ans+=n;
			System.out.printf("#%d %d%n",t,ans);
		}
	}
}

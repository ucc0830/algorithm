package twontiling;

import java.util.Scanner;

public class Main {
	static int[] dp;
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int n = sc.nextInt();
		dp = new int[n+4];
		dp[1]=1;
		dp[2]=2;
		for(int i=3;i<=n;i++) {
			dp[i]=(dp[i-1]+dp[i-2])%10007;
		}
		System.out.println(dp[n]);
	}
}

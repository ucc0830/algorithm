package stone;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] dp = new int[10];
		dp[1]=1;
		for(int i=1;i<=n;i++) {
			if(i<4) {
				dp[i]=dp[i-1]+1;
			}else if(i<6){
				dp[i]=Math.min(dp[i-1]+1, dp[i-4]+1);
			}else {
				dp[i]=Math.min(dp[i-6]+1, Math.min(dp[i-1]+1, dp[i-4]+1));
			}
		}
		System.out.println(dp[n]);
	}
}

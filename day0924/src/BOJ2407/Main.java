package BOJ2407;
/*
 * 조합
 * nCm의 조합의 경우의 수를 찾는 문제이다.
 * 숫자가 크기 때문에 int 범위를 벗어나므로 BigIntger 클래스를 사용해야 한다.
 */
import java.math.BigInteger;
import java.util.Scanner;

public class Main {
	static BigInteger[][] dp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n= sc.nextInt(),m=sc.nextInt();
		dp = new BigInteger[n+1][m+1];
		for(int i=0;i<=n;i++) {
			for(int j=0;j<=m;j++) {
				dp[i][j] = BigInteger.valueOf(-1);
			}
		}
//		BigInteger ans = func(n,m);
		BigInteger ans = func2(n,m);
		
		System.out.println(ans);
	}

	private static BigInteger func2(int n, int m) {
		for(int i=0;i<=n;i++) {
			for(int j=0;j<=Math.min(i, m);j++) {
				if(j==0 || j==i) {
					dp[i][j]=BigInteger.valueOf(1);
				}else {
					dp[i][j]=dp[i-1][j-1].add(dp[i-1][j]);
				}
			}
		}
		return dp[n][m];
	}

	private static BigInteger func(int n, int m) {
		if(m==0 || m==n) {
			return BigInteger.ONE;
		}
		if(dp[n][m].intValue() != -1) {
			return dp[n][m];
		}
		dp[n][m]=func(n-1,m-1).add(func(n-1,m));
		return dp[n][m];
	}
	

}

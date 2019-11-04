import java.util.Scanner;

public class FiboTest {
	static long[] dp;
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int n = sc.nextInt();
		dp = new long[n+3];
		dp[1]=1;
		dp[2]=1;
		for(int i=2;i<dp.length;i++) {
			dp[i]=dp[i-1]+dp[i-2];
		}
		
		//long res = fibo(n);
		System.out.println(dp[n]);
	}
	static long fibo(int n) {
		if(n<=2) {	
			return dp[n];
		}
		if(dp[n] != 0) return dp[n];
		else dp[n]=fibo(n-1)+fibo(n-2);
		return dp[n];
	}

}

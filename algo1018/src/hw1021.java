import java.util.Scanner;

public class hw1021 {
	static int n;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int[][] arr = new int[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				arr[i][j]=sc.nextInt();
			}
		}
		
		int pow = (int) Math.pow(n, 2);
		int sum = pow * (pow + 1) / 2;
		int row = sum / n;
		System.out.println("total = " + sum);
		System.out.println("row = " + row);
		System.out.println(check(arr, row));
	}

	private static boolean check(int[][] arr, int row) {
		for (int i = 0; i < n; i++) {// 각 행, 열
			int chk1 = 0;
			int chk2 = 0;
			for (int j = 0; j < n; j++) {
				chk1 += arr[i][j];
				chk2 += arr[j][i];
			}
			if (row != chk1)
				return false;
			if (row != chk2)
				return false;
		}

		int chk = 0;
		for (int i = 0; i < n; i++) {// 왼쪽 대각선
			chk += arr[i][i];
		}
		if (row != chk)
			return false;

		chk = 0;
		for (int i = n - 1; i >= 0; i--) {// 오른쪽 대각선
			chk += arr[n - 1 - i][i];
		}
		if (row != chk)
			return false;

		return true;
	}
}

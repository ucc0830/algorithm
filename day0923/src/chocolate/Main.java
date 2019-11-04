package chocolate;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt(),m=sc.nextInt();
		int ans = (n-1) + n*(m-1);
		System.out.println(ans);
	}

}

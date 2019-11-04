package stair;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] s = new int[n+1];
		int[] d = new int[n+1];
		for(int i=1;i<=n;i++) {
			s[i]=sc.nextInt();
		}
		
		d[1]=s[1];
		d[2]=s[1]+s[2];
		
		d[3]=Math.max(s[1]+s[3], s[2]+s[3]);
		
		for(int i=4;i<=n;i++) {
			d[i]=Math.max(d[i-3]+s[i-1]+s[i], d[i-2]+s[i]);
		}
		System.out.println(d[n]);
	}
}

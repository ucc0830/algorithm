package BOJ16916;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] a = sc.next().toCharArray();
		char[] b = sc.next().toCharArray();

		int[] pi = new int[b.length];
		int j = 0;
		for(int i=0;i<b.length;i++) {
			while(j>0 && b[i]!=b[j]) {
				j = pi[j-1];
			}
			if(b[i]==b[j]) {
				pi[i]=++j;
			}
		}
		
		j=0;
		for(int i=0;i<a.length;i++) {
			while(j>0 && a[i]!=b[j]) {
				j = pi[j-1];
			}
			if(a[i]==b[j]) {
				if(j == b.length-1) {
					//success
				}else {
					j++;
				}
			}
		}
		
	}

}

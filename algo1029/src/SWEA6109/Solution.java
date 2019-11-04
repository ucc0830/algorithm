package SWEA6109;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1;t<=T;t++) {
			int n = sc.nextInt();
			String cmd = sc.next();
			int[][] arr = new int[n][n];
			
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					arr[i][j]=sc.nextInt();
				}
			}
			
			move(arr,n,cmd);
			
		}//tc
		
	}//main

	private static void move(int[][] arr, int n, String cmd) {
		int[][] nmap = new int[n][n];
		Queue<Integer> q = new LinkedList<Integer>();
		
		if(cmd =="up") {
			
		}else if(cmd =="down") {
			
		}else if(cmd =="left") {
			
		}else if(cmd =="right") {
			
		}
		
	}
}

package SWEA1249;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	static final int INF = Integer.MAX_VALUE;
	static int[] dy = { 0, 1, 0, -1 }, dx = { 1, 0, -1, 0 };
	static class pos{
		int y,x,cost;

		public pos(int y, int x, int cost) {
			super();
			this.y = y;
			this.x = x;
			this.cost = cost;
		}
		
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int n = sc.nextInt();
			int[][] arr = new int[n][n];
			int[][] dist = new int[n][n];
			for (int i = 0; i < n; i++) {
				String s = sc.next();
				for (int j = 0; j < n; j++) {
					arr[i][j] = s.charAt(j)-'0';
					dist[i][j]=INF;
				}
			}
			dist[0][0] = 0;
			Queue<pos> q = new LinkedList<>();
			q.add(new pos(0,0,0));
			while(!q.isEmpty()) {
				pos p = q.poll();
				
				for(int i=0;i<4;i++) {
					int ny = p.y+dy[i];
					int nx = p.x+dx[i];
					
					if(ny<0 || nx<0 || ny>=n || nx>= n) continue;
					
					int ncost = p.cost+arr[ny][nx];
					
					if(ncost < dist[ny][nx]) {
						dist[ny][nx]=ncost;
						q.add(new pos(ny,nx,ncost));
					}
				}
				
			}
//			print(dist);
			System.out.printf("#%d %d%n",t,dist[n-1][n-1]);
			
			
		}//tc

	}//main

	private static void print(int[][] dist) {
		for(int i=0;i<dist.length;i++) {
			for(int j=0;j<dist[0].length;j++) {
				System.out.print(dist[i][j]+" ");
			}System.out.println();
		}
		
	}
}

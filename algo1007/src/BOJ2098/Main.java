package BOJ2098;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static int N;
	static final int INF = Integer.MAX_VALUE;
	static int ret = INF;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		int[][] dist = new int[N][N];
		for (int[] a : dist) {
			Arrays.fill(a, INF);
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				dist[i][j]=sc.nextInt();
			}
		}
		
		boolean[] visited = new boolean[N];
		visited[0] = true;
		tsp(0,0,0,0,"0",dist,visited);
		System.out.println(ret);
		
	}
	


	static void tsp(int start, int pos, int size, int lenth, String route, int[][] dist, boolean[] visited) {
		if(lenth>=ret) return;
		
		if(size == N-1) {
			if(dist[pos][start] != INF) {
				lenth += dist[pos][start];
			}
//			System.out.println(route + " " + ret + " " + lenth);
			ret = Math.min(ret, lenth);
//			System.out.println(route + " " + ret);
			return;
		}

		for(int i = 0 ; i <N; i++) {
			if(visited[i]) {
				continue;
			}
			if(dist[pos][i] != INF) {
				visited[i] = true;
				tsp(start, i,size+1, lenth + dist[pos][i], route +"-"+ i,dist,visited);
				visited[i] = false;
			}
		}
	}
}

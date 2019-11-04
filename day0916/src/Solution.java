import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static BufferedReader br;
	static StringTokenizer st;
	static int[] p;
	static int cnt;
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			p = new int[N+1];
			cnt=0;
			makeSet();
			
			for(int i=0;i<M;i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				unionSet(a,b);
			}
			boolean[] visited = new boolean[N+1];
			for(int i=1;i<p.length;i++) {
				visited[findSet(i)]=true;
			}
			for(int i=1;i<p.length;i++) {
				if(visited[i])
					cnt++;
			}
			System.out.printf("#%d %d\n",t,cnt);
		}
	}

	private static void unionSet(int a, int b) {
		int pa = findSet(a);
		int pb = findSet(b);
		if(pa==pb) return;
		else {
			p[pb]=pa;
		}
	}

	private static int findSet(int x) {
		if(x==p[x]) return x;
		p[x] = findSet(p[x]);
		return p[x];
	}

	private static void makeSet() {
		for(int i=1;i<p.length;i++) {
			p[i]=i;
		}
	}
	
}

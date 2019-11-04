import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;


public class Solution2 {
	static BufferedReader br;
	static StringTokenizer st;
	static class Node implements Comparable<Node>{
		int v1,v2,c;
		public Node(int v1, int v2, int c) {
			super();
			this.v1 = v1;
			this.v2 = v2;
			this.c = c;
		}
		@Override
		public int compareTo(Node o) {
			return this.c-o.c;
		}
	}
	static int[] p;
	static long rst;
	
	public static void main(String[] args) throws Exception{
		br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			ArrayList<Node> list = new ArrayList<>();
			p = new int[V+1];
			makeSet();
			rst=0;
			
			for(int i=0;i<E;i++	) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				list.add(new Node(a,b,c));
			}
			Collections.sort(list);
			
			for(Node n : list) {
				unionSet(n);
			}
			System.out.printf("#%d %d\n",t,rst);
		}
	}
	private static void unionSet(Node n) {
		int pa = findSet(n.v1);
		int pb = findSet(n.v2);
		if(pa==pb) return;
		p[pb]=pa;
		rst += n.c;
	}
	private static int findSet(int x) {
		if(p[x]==x) return x;
		p[x] = findSet(p[x]);
		return p[x];
	}
	private static void makeSet() {
		for(int i=1;i<p.length;i++)
			p[i]=i;
	}

}

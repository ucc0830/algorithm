import java.util.TreeSet;

public class KruscalTest {
	static int[] p;
	static int result = 0;
	static int cnt = 0;
	public static void main(String[] args) {
		Edge e1 = new Edge(5,3,18);
		Edge e2 = new Edge(1,2,21);
		Edge e3 = new Edge(2,6,25);
		Edge e4 = new Edge(0,2,31);
		Edge e5 = new Edge(0,1,32);
		Edge e6 = new Edge(3,4,34);
		Edge e7 = new Edge(5,4,40);
		Edge e8 = new Edge(2,4,46);
		Edge e9 = new Edge(0,6,51);
		Edge e10 = new Edge(4,6,51);
		Edge e11 = new Edge(0,5,60);
		int V = 7;
		p = new int[V];
		makeSet();
		
		TreeSet<Edge> tree = new TreeSet();
		
		tree.add(e2);
		tree.add(e1);
		tree.add(e9);
		tree.add(e8);
		tree.add(e6);
		tree.add(e3);
		tree.add(e7);
		tree.add(e4);
		tree.add(e10);
		tree.add(e5);
		tree.add(e11);
		
		for(Edge e : tree) {
			unionSet(e);
			if(cnt == V-1 ) { break;}// 가지치기				
		}
		System.out.println(result);
	}
	static int findSet(int x) {
		if(x == p[x]) {
			return x;
		}
		return p[x] = findSet(p[x]);
	}
	static void unionSet(Edge e) {
		int x = findSet(e.x);
		int y = findSet(e.y);
		if(x != y) {
			p[y] = x; 			result += e.weight;			cnt++;
		}		
	}
	static class Edge implements Comparable<Edge> {
		int x;
		int y;
		int weight;
		public Edge(int x, int y, int weight) {
			this.x = x;			this.y = y;			this.weight = weight;
		}
		public int compareTo(Edge o) {
			return this.weight > o.weight ? 1 : -1 ;   // -1, 0, 1
		}		
	}
	static void makeSet() {
		for(int i = 0 ; i < p.length; i++) {
			p[i] = i;
		}
	}
//	makeSet, findSet, unionSet


}

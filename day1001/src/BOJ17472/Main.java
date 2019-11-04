package BOJ17472;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int[][] map;
	static boolean[][] visited;
	static boolean[] check;
	static class Pos {
		int y, x;
		public Pos(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
	}
	static int[] dy = { 0, 1, 0, -1 }, dx = { 1, 0, -1, 0 };
	static int idx, n, m;
	static class Node{
		int n1,n2,w;
		public Node(int n1, int n2, int w) {
			super();
			this.n1 = n1;
			this.n2 = n2;
			this.w = w;
		}
	}
	static ArrayList<Node> list;
	static int[] p;
	static int ans;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		map = new int[n][m];
		visited = new boolean[n][m];
		list = new ArrayList<>();
		idx = 1;
		ans = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (!visited[i][j] && map[i][j] == 1) {
					bfs(i, j);
					idx++;// 섬의 인덱스
				}
			}
		}
//		print(map);
		visited = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(!visited[i][j] && map[i][j] != 0) {
					visited[i][j]=true;
					z:for(int z=0;z<4;z++) {
						boolean flag = false;
						int cnt = 0;
//						System.out.println("idx == "+i+", "+j+", "+z);
						int ny = i;
						int nx = j;
						while(true) {
							ny += dy[z];
							nx += dx[z];
							if(ny < 0 || nx < 0 || ny >= n || nx >= m ||map[ny][nx]==map[i][j]) {
								break;
							}
							if(map[ny][nx]!=0) {
								flag=true;
								break;
							}
							cnt++;
						}
//						System.out.println("cnt = "+ cnt+", flag = "+flag);
						if(flag && cnt>=2) {
							list.add(new Node(map[i][j],map[ny][nx],cnt));
						}
					}
				}
			}
		}
		Collections.sort(list,new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				return ((int)o1.w-o2.w);
			}
		});
//		System.out.println("idx = "+idx);
		p = new int[idx];
		check = new boolean[idx];
		makeSet();
		for(int i=0;i<list.size();i++) {
//			System.out.println(list.get(i).n1+", "+list.get(i).n2+", "+list.get(i).w);
			unionSet(list.get(i));	
		}
//		System.out.println(Arrays.toString(p));
		for(int i=1;i<p.length;i++) {
			for(int j=0;j<check.length;j++) {
				check[findSet(i)]=true;
			}
		}
		int cc = 0;
		for(int i=0;i<check.length;i++) {
			if(check[i]) cc++;
//			System.out.println(check[i]);
		}
		
		if(cc == 1 ){
			System.out.println(ans);
		}else {
			System.out.println(-1);
		}
	}

	private static void makeSet() {
		for(int i=0;i<p.length;i++) {
			p[i]=i;
		}
	}

	private static void unionSet(Node node) {
		int py = findSet(node.n1);
		int px = findSet(node.n2);
//		System.out.println("pp = = "+py+", "+px);
		if(py==px) return;
		p[py]=px;
		ans += node.w;
	}

	private static int findSet(int x) {
		if(p[x] == x) return x;
		int idx = findSet(p[x]);
		return idx;
	}

	private static void print(int[][] map2) {
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				System.out.print(map2[i][j]+" ");
			}System.out.println();
		}
	}

	private static void bfs(int y, int x) {
		Queue<Pos> q = new LinkedList<Pos>();
		visited[y][x] = true;
		map[y][x] = idx;
		q.add(new Pos(y, x));
		while (!q.isEmpty()) {
			Pos cur = q.poll();
			for (int z = 0; z < 4; z++) {
				int ny = cur.y + dy[z];
				int nx = cur.x + dx[z];
				if (ny < 0 || nx < 0 || ny >= n || nx >= m || map[ny][nx] == 0||visited[ny][nx])
					continue;
				map[ny][nx] = idx;
				visited[ny][nx] = true;
				q.add(new Pos(ny, nx));
			}
		}
	}
}

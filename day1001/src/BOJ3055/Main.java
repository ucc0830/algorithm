package BOJ3055;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
//import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	static int[] dy = { 0, 1, 0, -1 }, dx = { 1, 0, -1, 0 };
	static class Pos {
		int y, x;

		public Pos(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
	}
	
	static int r, c;
	static Queue<Pos> q, qq;
	static char[][] chr;
	static BufferedReader br;
	static StringTokenizer st;
	static boolean[][] visited,visited2;
	
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
//		Scanner sc = new Scanner(System.in);
		st= new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		q = new LinkedList<>();
		qq = new LinkedList<>();
		chr = new char[r][c];
		visited=new boolean[r][c];
		visited2=new boolean[r][c];
		
		for (int i = 0; i < r; i++) {
			String s = br.readLine();
			for (int j = 0; j < c; j++) {
				chr[i][j] = s.charAt(j);
				if (chr[i][j] == '*') {
					q.add(new Pos(i, j));
					visited[i][j]=true;
				} else if (chr[i][j] == 'S') {
					qq.add(new Pos(i, j));
					visited2[i][j]=true;
				}
			}
		}
		int time = 0;
		int cnt = 0;
		while (true) {
			cnt++;
			if (qq.size()==0) {
				System.out.println("KAKTUS");
				return;
			}
			time++;
			bfs();// 물
			if(bfs2()) {
//				System.out.println("cnt-"+cnt);
				System.out.println(time);
				return;
			}

		} // while
	}

//	private static void print(char[][] chr) {
//		for(int i=0;i<r;i++) {
//			for(int j=0;j<c;j++) {
//				System.out.print(chr[i][j]);
//			}System.out.println();
//		}
//	}

	private static boolean bfs2() {// 고슴도치
		int siz = qq.size();
		for (int i = 0; i < siz; i++) {
			Pos cur = qq.poll();
			for (int z = 0; z < 4; z++) {
				int ny = cur.y + dy[z];
				int nx = cur.x + dx[z];
				if (ny < 0 || nx < 0 || ny >= r || nx >= c ||visited2[ny][nx]|| chr[ny][nx] == 'X' || chr[ny][nx] == '*'||chr[ny][nx]=='S')
					continue;
				if (chr[ny][nx] == 'D') {
					return true;
				}
				chr[ny][nx] = 'S';
				visited2[ny][nx]=true;
				qq.add(new Pos(ny, nx));
			}
		}
		return false;
	}

	private static void bfs() {// 물
		int siz = q.size();
		for (int i = 0; i < siz; i++) {
			Pos cur = q.poll();
			for (int z = 0; z < 4; z++) {
				int ny = cur.y + dy[z];
				int nx = cur.x + dx[z];
				if (ny < 0 || nx < 0 || ny >= r || nx >= c ||visited[ny][nx]|| chr[ny][nx] == 'D' || chr[ny][nx] == 'X')
					continue;
				chr[ny][nx] = '*';
				visited[ny][nx]=true;
				q.add(new Pos(ny, nx));
			}
		}
	}// bfs
}

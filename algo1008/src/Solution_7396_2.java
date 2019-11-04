import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// SWEA 7396. 종구의 딸이름 짓기
public class Solution_7396_2 {
	static int N,M;
	static String result = "";
	static char[][] map;
	static boolean [][] v;
	static int[] dx = {1,0};
	static int[] dy = {0,1};

	public static void main(String[] args)  throws IOException{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(reader.readLine());
		StringTokenizer st;		
		for(int t = 1; t <= TC; t++) {

			st = new StringTokenizer(reader.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new char[N][M];
			v = new boolean[N][M];
			for(int i = 0 ; i < N; i++) {
				map[i] = reader.readLine().toCharArray();
			}
			result = bfs();
			System.out.println("#" + t + " " + result);
		}
	}//main

	static class Data{
		int x,y;
		char ch;
		Data(int x, int y, char ch){
			this.x = x;
			this.y = y;
			this.ch = ch;
		}
	}//data

	static String bfs() {
		int x = 0;
		int y = 0;
		char ch = map[y][x];
		Data data = null;
		Queue<Data> q = new LinkedList<>();
		StringBuilder sb = new StringBuilder();
		v[y][x] = true;
		q.add(new Data(x,y,ch));
		char next;
		int size;
		while(!q.isEmpty()) {
			sb.append(ch);
			size = q.size(); //현재 큐  사이즈 만큼 다 뽑아서 문자열 만들기			
			next = 'z';  // 가장 큰값
			int nx,ny;
			for(int i = 0 ; i < size;i++) {
				data = q.poll();
				x = data.x;
				y = data.y;
				if(ch == data.ch) {
					for(int j = 0 ; j < 2; j++) {
						nx = x + dx[j];
						ny = y + dy[j];
						if(nx >= M || ny >= N) {
							continue;
						}
						if(v[ny][nx]) {
							continue;
						}
						v[ny][nx] = true;
						if(next > map[ny][nx]) { //다음 철자 찾기
							next = map[ny][nx];
						}
						q.offer(new Data(nx, ny, map[ny][nx]));
					}
				}
			}
			ch = next;
		}
		return sb.toString();
	}
}

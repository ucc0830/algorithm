import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main17144 {
	
	static BufferedReader br;
	static StringTokenizer st;
	static int[][] map,map2;
	
	public static void main(String[] args) throws Exception{
		br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for(int t=1;t<=tc;t++) {
			st = new StringTokenizer(br.readLine());
			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			int T = Integer.parseInt(st.nextToken());

			map = new int[R][C];
			map2 = new int[R][C];
			
			for(int i=0;i<R;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<C;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int cnt = 0;
			while(cnt<T) {
				
				for(int i=0;i<R;i++) {
					for(int j=0;j<C;j++) {
						if(map[i][j]>0) {
							bfs();
						}
					}
				}
				
				
				
				
				
				
				cnt++;
			}
			
		}
	}

	private static void bfs() {
		for(int i=0;i<4;i++) {
			
			
		}
	}
}














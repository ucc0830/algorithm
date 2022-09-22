import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SolutionCounselor {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static class Pos {
		int y, x;

		public Pos(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}

	}

	static long ans;

	public static void main(String[] args) throws Exception {
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			ans = Long.MAX_VALUE;
			int N = Integer.parseInt(br.readLine());
			ArrayList<Pos> list = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int y = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				list.add(new Pos(y, x));
			}
			boolean[] visited = new boolean[N];
			comb(0, visited, list, N / 2);
			System.out.println(t + " " + ans);
		} // tc

	}// main

	private static void comb(int idx, boolean[] visited, ArrayList<Pos> list, int r) {
		if (r == 0) {
			long sum = calc(visited, list);
			if (ans > sum)
				ans = sum;
			return;
		}
		for (int i = idx; i < list.size(); i++) {
			visited[i] = true;
			comb(i + 1, visited, list, r - 1);
			visited[i] = false;
		}
	}

	private static long calc(boolean[] visited, ArrayList<Pos> list) {
//		ArrayList<Pos> temp = new ArrayList<>();
//		for(int i=0;i<list.size();i++) {
//			if(visited[i]) {
//				for(int j=0;j<list.size();j++) {
//					if(!visited[j]) {
//						visited[j]=true;
//						int dy = list.get(i).y - list.get(j).y;
//						int dx = list.get(i).x - list.get(j).x;
//						temp.add(new Pos(dy,dx));
//					}
//				}
//			}
//		}
//		int sumY=0,sumX=0;
//		for(int i=0;i<temp.size();i++) {
//			sumY+=temp.get(i).y;
//			sumX+=temp.get(i).x;
//		}
//		
//		return (int) (Math.pow(sumY, 2) + Math.pow(sumX, 2));

		long sumY = 0, sumX = 0;
		for (int i = 0; i < list.size(); i++) {
//			if (!visited[i]) {
//				list.get(i).y = list.get(i).y * (-1);
//				list.get(i).x = list.get(i).x * (-1);
//			}
			if(!visited[i]) {
				sumY-=list.get(i).y;
				sumX-=list.get(i).x;
			}else {
				sumY+=list.get(i).y;
				sumX+=list.get(i).x;
			}
		}
//		for (int i = 0; i < list.size(); i++) {
//			sumY = sumY + list.get(i).y;
//			sumX = sumX + list.get(i).x;
//		}
		return (long) (Math.pow(sumY, 2) + Math.pow(sumX, 2));
	}
}

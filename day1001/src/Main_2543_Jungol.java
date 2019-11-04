import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_2543_Jungol {
	public static class Node{
		int startX;
		int startY;
		int endX;
		int endY;
		public Node(int startX, int startY, int endX, int endY) {
			super();
			this.startX = startX;
			this.startY = startY;
			this.endX = endX;
			this.endY = endY;
		}
		@Override
		public String toString() {
			return "Node [startX=" + startX + ", startY=" + startY + ", endX=" + endX + ", endY=" + endY + "]";
		}
	}
	static int[][] tile;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int X = sc.nextInt();
		int Y = sc.nextInt();
		tile = new int[N][N];
		tile[X][Y]= -1;
		//-1의 위치를 정하면 가장 정 중앙의 타일을 알수 있다.
		//  1  2    3 3  4 4
		//1 1  2 2    3  4
		BFS(N);
		for (int i = 0; i < tile.length; i++) {
			for (int j = 0; j < tile.length; j++) {
				if(tile[i][j]==-1) {
					System.out.print("0 ");
				}else {
					System.out.print(tile[i][j]+" ");
				}
			}
			System.out.println();
		}
	}
	
	public static void BFS(int N) {
		Queue<Node> q = new LinkedList<Node>();
		q.offer(new Node(0, 0, N, N));
		boolean[] check = new boolean[4];
		while(!q.isEmpty()) {
			Node n = q.poll();
			check[0] = confirm(n.startX, (n.startX+n.endX)/2, n.startY, (n.startY+n.endY)/2);
			check[1] = confirm(n.startX, (n.startX+n.endX)/2, (n.startY+n.endY)/2, n.endY);
			check[2] = confirm((n.startX+n.endX)/2, n.endX, n.startY, (n.startY+n.endY)/2);
			check[3] = confirm((n.startX+n.endX)/2, n.endX, (n.startY+n.endY)/2, n.endY);
			int idx = 0;
			for (int i = 0; i < check.length; i++) {
				if(!check[i]) {
					idx=i;//check 값이 true인 인덱스 찾기
				}
			}
			switch(idx) {
			case 0:
				tile[(n.startX+n.endX)/2-1][(n.startY+n.endY)/2]=idx+1;//1
				tile[(n.startX+n.endX)/2][(n.startY+n.endY)/2-1]=idx+1;//3
				tile[(n.startX+n.endX)/2][(n.startY+n.endY)/2]=idx+1;//4
				break;
			case 1:
				tile[(n.startX+n.endX)/2-1][(n.startY+n.endY)/2-1]=idx+1;//2
				tile[(n.startX+n.endX)/2][(n.startY+n.endY)/2-1]=idx+1;//3
				tile[(n.startX+n.endX)/2][(n.startY+n.endY)/2]=idx+1;//4
				break;
			case 2:
				tile[(n.startX+n.endX)/2-1][(n.startY+n.endY)/2-1]=idx+1;//2
				tile[(n.startX+n.endX)/2-1][(n.startY+n.endY)/2]=idx+1;//1
				tile[(n.startX+n.endX)/2][(n.startY+n.endY)/2]=idx+1;//4
				break;
			case 3:
				tile[(n.startX+n.endX)/2-1][(n.startY+n.endY)/2-1]=idx+1;//2
				tile[(n.startX+n.endX)/2-1][(n.startY+n.endY)/2]=idx+1;//1
				tile[(n.startX+n.endX)/2][(n.startY+n.endY)/2-1]=idx+1;//3
				break;
			}
			if(n.endX-n.startX>2) {
				q.offer(new Node(n.startX, n.startY, (n.startX+n.endX)/2,  (n.startY+n.endY)/2));//2
				q.offer(new Node(n.startX,(n.startY+n.endY)/2, (n.startX+n.endX)/2, n.endY));//1
				q.offer(new Node((n.startX+n.endX)/2, n.startY, n.endX, (n.startY+n.endY)/2));//3
				q.offer(new Node((n.startX+n.endX)/2, (n.startY+n.endY)/2, n.endX, n.endY));//4
			}
		}
	}
	public static boolean confirm(int startX, int endX,int startY,int endY) {
		//주어진 범위 내에 배수구가 있으면 true, 없으면 false 값을 반환한다.
		boolean conf = true;
		for (int i = startX; i < endX; i++) {
			for (int j = startY; j < endY; j++) {
				if(tile[i][j]!=0) {
					return false;
				}
			}
		}
		return conf;
	}
}

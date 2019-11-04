import java.util.Scanner;


public class Main_JO_2543 {
	static int[][] map;
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int hi = sc.nextInt();
		int hj = sc.nextInt();
		map = new int[N][N];
		divide(0,0,N,N,hi,hj);
		for(int i=0; i<N; i++){
			for(int j=0; j<N; j++){
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}

	static void divide(int si, int sj, int ei, int ej, int hi, int hj){
		if(ei-si==1)
			return;

		int mi = (si+ei)/2;
		int mj = (sj+ej)/2;

		int block = check(si,sj,ei,ej,hi,hj);

		switch(block){
		case 1: // 1번블럭 _|
			map[mi][mj] = map[mi-1][mj] = map[mi][mj-1] = block;
			divide(si, sj, mi, mj, hi, hj); // 좌상
			divide(si, mj, mi, ej, mi-1, mj); // 우상
			divide(mi, sj, ei, mj, mi, mj-1); // 좌하
			divide(mi, mj, ei, ej, mi, mj); // 우하
			break;

		case 2: // 2번 블럭 |_
			map[mi][mj] = map[mi][mj-1] = map[mi-1][mj-1] = block;
			divide(si, sj, mi, mj, mi-1, mj-1); // 좌상
			divide(si, mj, mi, ej, hi, hj); // 우상
			divide(mi, sj, ei, mj, mi, mj-1); // 좌하
			divide(mi, mj, ei, ej, mi, mj); // 우하
			break;
		case 3: // 3번 블럭 ^|
			map[mi][mj] = map[mi-1][mj] = map[mi-1][mj-1] = block;
			divide(si, sj, mi, mj, mi-1, mj-1); // 좌상
			divide(si, mj, mi, ej, mi-1, mj); // 우상
			divide(mi, sj, ei, mj, hi, hj); // 좌하
			divide(mi, mj, ei, ej, mi, mj); // 우하
			break;

		case 4: // 4번 블럭 |^
			map[mi-1][mj-1] = map[mi-1][mj] = map[mi][mj-1] = block;
			divide(si, sj, mi, mj, mi-1, mj-1); // 좌상
			divide(si, mj, mi, ej, mi-1, mj); // 우상
			divide(mi, sj, ei, mj, mi, mj-1); // 좌하
			divide(mi, mj, ei, ej, hi, hj); // 우하
			break;
		}
	}

	static int check(int si, int sj, int ei, int ej, int hi, int hj){
		int mi = (si+ei)/2;
		int mj = (sj+ej)/2;
		if(si<=hi && hi<mi && sj<=hj && hj<mj)
			return 1;
		else if( si<=hi && hi<mi&& mj<=hj && hj<ej)
			return 2;
		else if(mi<=hi && hi<ei && sj<=hj && hj<mj)
			return 3;
		else
			return 4;

	}

}


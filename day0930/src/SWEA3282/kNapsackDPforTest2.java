package SWEA3282;

import java.util.Arrays;

public class kNapsackDPforTest2 {
//	0은 가치 , 1은 무게
	static int[][] items = {
			{0,0},
			{10,5},
			{40,4},
			{30,6},
			{50,3}
	};
	static int N =5;
	static int K[][];
	public static void main(String[] args) {
		int capacity = 10;
		K = new int[N][capacity];
//		i는 각각의 물건 즉 i가 1이면 1번 물건만 고려함
		for(int i = 1 ; i < N; i++) {
			for(int w = 1; w < capacity; w++) { // W는 각각의 무게 ,가방무게
// 		i번째 무게가 한계치 w 보다 무거우면 그 상품을 담을 수 없기 때문에 i-1번째의 가치를 넣어준다.
				if(items[i][1] > w ) {
					K[i][w] = K[i-1][w];
				}else {
// 		그렇지 않으면 i-1번째 현재 까지의 가치와 
// 		i번째에서 w만큼의 무게를 뺐을 때의 가치에 현재 상품을 취했을 경우 얻을 수 있는 가치를 누적한 것 중 큰 값으로 변경한다.				
					K[i][w] = Math.max( K[i-1][w] , K[i-1][w-items[i][1]]+items[i][0] );
				}
			}
		}
		for(int[] m : K) {
			System.out.println(Arrays.toString(m));
		}
//		System.out.println(Arrays.deepToString(K));
		System.out.printf("knapsack(%d,%d)=%d%n",0,capacity, K[N-1][capacity-1] );
	}
}
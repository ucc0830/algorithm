package SWEA3282;

// dfs 적용 사례
public class kNapsackTest {
	static int[][] items = { { 10, 5 }, { 40, 4 }, { 30, 6 }, { 50, 3 } };
	static int N = 4;

	static int knapsack(int pos, int capacity) {
		System.out.println(pos+", "+capacity);
		if (pos == N)
			return 0;
		if (capacity <= 0)
			return 0;
		int ret = 0;
		if (items[pos][1] <= capacity) // pos 위치의 물건을 배낭에 넣을 수 있을때
			ret = knapsack(pos + 1, capacity - items[pos][1]) + items[pos][0];
		// pos 위치의 물건을 넣지 않을때우 넣었을 경우 두개 중 큰값을 반환한다.
		System.out.println("ret -- 1 "+ret+", pos "+pos);
		ret = Math.max(ret, knapsack(pos + 1, capacity));
		System.out.println("ret -- 2 "+ret+", pos "+pos);
		return ret;
	}

	public static void main(String[] args) {
		int capacity = 10;
		System.out.printf("knapsack(%d,%d)=%d%n", 0, capacity, knapsack(0, capacity));
	}
}
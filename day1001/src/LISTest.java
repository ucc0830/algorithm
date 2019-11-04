
import java.util.ArrayList;
import java.util.Arrays;

public class LISTest {

	public static void main(String[] args) {
		int[] arr = {3,2,6,4,5,1};
//				doLst1(arr);  // 2의 N승으로 구하기
				doLst2(arr);  // N 제곱으로 구하기
//			doLst3(arr);  // Nlon/gN으로 구하기
	}

	//	O(nLogn)으로 접근하기
	//	1. 배열 마지막 요소보다 새로운 수가 크다면, 배열에 넣는다.
	//	2. 그렇지 않다면, 그 수가 들어갈 자리에 넣는다. (이분 탐색을 통해 들어갈 자리를 찾는다)
	static void doLst3(int[] arr) {
		int[] dp = new int[arr.length];
		dp[0] = arr[0]; 
		int idx = 0; 
		System.out.println(Arrays.toString(dp));
		for (int i = 1; i < arr.length; i++) { 
			if (dp[idx] < arr[i]) { 
				dp[++idx] = arr[i]; 
			} else {
				System.out.println(idx+", "+arr[i]);
				int ii = lower_bound(dp, idx, arr[i]);
				dp[ii] = arr[i];
			}
			System.out.println(Arrays.toString(dp));
		}
		System.out.println(idx + 1);
	}
	static int lower_bound(int[] dp, int end, int n) {
		int start = 0;

		while (start < end) {
			int mid = (start + end) / 2;
			System.out.println(mid);
			if (dp[mid] >= n) {
				end = mid;
			} else {
				start = mid + 1;
			}
		}
		System.out.println(end);
		return end;
	}
	//	O(n2) 으로 접근하기 - dp 기존에 얻어진 수보다 많은 횟수면 저장하고 다음숫자 비교함
	static void doLst2(int[] arr){
		int[] dp = new int[arr.length];
		for(int i = 0; i < dp.length; i++) {
			dp[i] = 1;
			for(int j = 1; j < i; j++) {
				if(arr[i] > arr[j] && dp[i] < dp[j]+1) {
					dp[i] = dp[j] + 1;
				}
			}
		}
		System.out.println(Arrays.toString(dp));
		int max = Arrays.stream(dp).max().getAsInt();
		System.out.println(max);
	}
	//완전 탐색으로 구하기
	static void doLst1(int[] arr) {
		int size = 1<<arr.length;
		System.out.println(size);
		ArrayList<Integer> list = new ArrayList<Integer>();
		int max = -1;
		int cnt = 0;
		for(int i = size-1; i > 0; i--) {
			list.clear();
			for(int j = 0; j < arr.length; j++) {
				if((i & 1<<j) != 0) {
					list.add(arr[j]);
				}
			}
			System.out.println(list + " , " + i);
			max = Math.max(max, count(list, i));
			cnt++;
			if(i>>max == 0) {
				break;
			}
		}
		System.out.println(max + " , cnt : " + cnt);
	}
	
	static int count(ArrayList<Integer> list, int j) {
		int size  = list.size();
		for(int i = 1 ; i < list.size(); i++) {
			if(list.get(i-1) > list.get(i)) {
				size = 1;
				break;
			}
		}
//		if(size == list.size()) {
//			System.out.println(list + " , " + j);
//		}
		return size;
	}
}

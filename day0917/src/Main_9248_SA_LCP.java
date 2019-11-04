import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
// 9428 Suffix Array
public class Main_9248_SA_LCP {
	public static int d = 1;
	public static char[] s;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String ss = br.readLine();
		
		s = ss.toCharArray();
		int len = s.length;
		Integer[] sa = new Integer[len];  //SA 첨자 배열
		int[] group = new int[len];
//		int[] LCP = new int[len];
		
		for(int i = 0; i < len; i++)
		{
			sa[i] = i;
			group[i] = s[i];
//			LCP[i] = -1;
		}
		
		Comparator<Integer> comp = new Comparator<Integer>() {
			public int compare(Integer a, Integer b) {
				if(group[a] != group[b]) // 같은 그룹이 아니면 그룹별 그대로 정렬
					return group[a] - group[b];
				//	같은 그룹이면 1,2,4,8 번째의 문자열 비교 후 정렬
				a += d;
				b += d;

				if(a < len && b  < len)	{ //문자열 범위가 넘어가지 않도록(첨자오류 방지)
					return group[a] - group[b];
				}
				else
					return a > b  ? -1 : a == b ? 0 : 1; //문자열 길이가 짧은 것이 앞에 오도록 함
			}
		};
		int[] temp = new int[len]; //임시 그룹 배열
		
		
		while(d <= len){
			System.out.println();
			Arrays.sort(sa, comp); // 문자열 기준으로 정렬
			Arrays.fill(temp, 0);  //임시 배열 초기화

			for(int i = 1; i < len; i++){
				if(comp.compare(sa[i-1], sa[i]) != 0) { // 같지 않으면 다음그룹으로 변경
					temp[i] = temp[i-1] + 1;
				}else {			// 같은 그룹이면 앞 그룹으로 설정
					temp[i] = temp[i-1];
				}
			}
			for(int i = 0; i < len; i++) // 새로 얻어진 그룹으로 group변경
				group[sa[i]] = temp[i];

			d <<= 1; // 1, 2, 4, 8 ,16으로 변경하기
		}
//		사전 순으로 정렬되어있는 SA는 이웃할 때 겹치는 부분이 많고, 
//		이웃하지 않을 때는 겹치는 부분이 이웃할 때 보다는 무조건 작거나 같다 =>O(n)으로 LCP 구할 수 있음
		
//		group과 sa배열은 서로 반대의 값을 가지고 있다.(멱함수 관계)
		for(int i = 0 ; i < group.length; i++) {
			System.out.println(i + ", " + group[i] + ",  "+ sa[i] + ", " + group[sa[i] ] + ", " + sa[group[i]]);
		}
		int same = 0;
		for(int i = 0; i<len; i++){
			if(same > 0) {
				same--;
			}else{
				same = 0;
			}
			if(group[i] == len-1) // 비교되는 j의 범위 벗어나지 않도록 제어 
				continue;
			int j = sa[group[i]+1]; // 4,0,1,2,3번호 차출
			System.out.println("j : " + j);
			while(true) {
				if(i+same >= len || j+same >= len) { // 범위가 벗어나면 반복 멈춤
					break; 
				}
				if(s[i+same]==s[j+same]){ //  반복 문자열이면 LCP 값을 1씩 증가
					same++;
				}else {
					break;
				}
			}
//			LCP[group[i]] = same;
		}
			
//		System.out.print("sa  : " );
		for(int i = 0; i<len; i++)
			System.out.print(sa[i] + 1 + " ");
		System.out.println();
//		System.out.print("lcp : " );
		System.out.print("x ");
//		for(int i = 0; i<len-1; i++)
//			System.out.print(LCP[i] + " ");
//		System.out.println();
//		for(int i = 0; i<len; i++)
//			System.out.println(i + " "+(sa[i] + 1) + " "+ss.substring(sa[i]) + " " + (i==0? "x" :LCP[i-1]));
//		System.out.println();
		br.close();
	}
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class SATEst {
	public static int d = 1;
	public static char[] s;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		String ss = br.readLine();
		String ss = "banana";

		s = ss.toCharArray();
		int len = s.length;
		Integer[] sa = new Integer[len];  // SA 첨자 배열 위치값 저장 배열
		int[] group = new int[len];		  // 그룹 관리 배열

		for(int i = 0; i < len; i++){
			sa[i] = i;					 // 접미사배열 초기 위치값 저장 
			group[i] = s[i];			 // 첫 번째 문자열 1차 그룹 설정
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
		for(int i = 0; i<len; i++)
			System.out.println(sa[i] + 1 + " " + ss.substring(sa[i]));
	}
}

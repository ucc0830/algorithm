

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;
// 7701. 염라대왕의 이름 정렬
public class Solution_7701 {
	public static void main(String[] args)  throws IOException{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(reader.readLine());
		int N = 0;
		TreeSet<String> set = new TreeSet<>(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				if(o1.length() != o2.length()) {
					return o1.length() - o2.length();
				}else {
					return o1.compareTo(o2);	
				}
				
			}
		});
		for(int t = 1; t <= TC; t++) {
			set.clear();
			N = Integer.parseInt(reader.readLine());
			for(int i = 0; i < N; i++) {
				set.add(reader.readLine());
			}
			System.out.println("#" + t);
			Iterator<String> it = set.iterator();			
			while(it.hasNext()) {
				System.out.println(it.next());
			}

		}
	}
}

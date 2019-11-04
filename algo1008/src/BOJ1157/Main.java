package BOJ1157;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		s = s.toLowerCase();
		Map<Character, Integer> map = new HashMap<>();
		
		for(int i=0;i<s.length();i++) {
			if(map.containsKey(s.charAt(i))) {
				map.put(s.charAt(i),map.get(s.charAt(i))+1);
			}
			else {
				map.put(s.charAt(i), 1);
			}
		}
		Set<Character> set = map.keySet();
		Iterator<Character> it = set.iterator();
		int max = 0;
		char ch = '0';
		while(it.hasNext()) {
			char tmp = it.next();
			if(max<map.get(tmp)) {
				max=map.get(tmp);
				ch=tmp;
			}
		}
		Collection<Integer> list = map.values();
		Iterator<Integer> iit = list.iterator();
		int cnt = 0;
		while(iit.hasNext()) {
			if(max ==iit.next())
				cnt++;
		}
		if(cnt>1) {
			System.out.println("?");
		}else {
			System.out.println(Character.toUpperCase(ch));
		}
	}
}

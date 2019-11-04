package trie;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class TrieTest {
	static class Trie{
		Node root;
		Trie(){// 루트 노드 공백으로 생성
			root = new Node('\u0000');
		}
		//trie 삽입
		public void insert(String word) {
			if(search(word)) {
				return;
			}
			Node current = root;
			for(char ch : word.toCharArray()) {
				Node child = current.subNode(ch);
				if(child == null) {
					current.childList.add(new Node(ch));
					current = current.subNode(ch);
				}else{
					current = child;
				}
				current.count++;  //카운트 1증가
			}
			current.leaf = true;  //단말 문자열 저장
		}
		public boolean search(String word) {
			boolean flag = true;
			Node current = root;
			for(char ch : word.toCharArray()) {
				Node temp = current.subNode(ch); 
				if(temp == null) {
					flag = false;
					break;
				}
				current = temp;
			}
			//	찾은 노드가 마지막이면 찾은것 아니면 중간문자열
			if(!current.leaf) {
				flag = false;
			}
			return flag;
		}
		public void remove(String word) {
			if(!search(word)) {
				System.out.println(word + "는 없는 단어");
				return;
			}
			Node current = root;
			Node child;
			for(char nextChar : word.toCharArray()) {
				child = current.subNode(nextChar);
				if(child.count == 1) {
					current.childList.remove(child);
					return;
				}else {
					child.count--;
					current = child;
				}
			}
//			중간 문자열 korea  kor 삭제된 경우   leaf 속성만 변경함
			current.leaf = false;
		}
		//		Trie 내부 모든 문자열 반환하는 메소드
		Iterator<String> iterator(){
			Iterator<String> iterator = null;
			Set<String> set = new TreeSet<>();
			trieAllString(root, "", set);
			iterator = set.iterator();
			return iterator;
		}
		void trieAllString(Node current, String key, Set<String> set) {
			//단어인 노드이면 Set에 추가하기
			if(current.leaf) {
				set.add(key);
			}
			// 단위 노드를 모두 찾아서 검색
			ArrayList<Node> childList = current.childList;
			if(childList != null) {
				for(Node nextNode : childList) {
					trieAllString(nextNode, key+nextNode.data, set);
				}
			}
		}
	}
	static class Node{
		char data;
		boolean leaf;
		int count;
		ArrayList<Node> childList;
		Node(char data){
			this.data = data;
			leaf = false;
			count = 0;
			childList = new ArrayList<Node>();
		}
		Node subNode(char nextChar) {
			Node temp = null;
			for(Node n : childList) {
				if(n.data == nextChar) {
					temp = n;
					break;
				}
			}
			return temp;
		}
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return data + "(" + leaf + ")";
		}

	}
	public static void main(String[] args) {
		Trie trie = new Trie();
		String s = "abac";
		for(int i = 0 ; i < s.length(); i++) {
			trie.insert(s.substring(i));
		}
		System.out.println(trie.search("bac"));
		System.out.println(trie.search("aca"));
		Iterator<String> list = trie.iterator();
		while(list.hasNext()) {
			System.out.println(list.next());
		}

//		trie.insert("aa");
//		trie.insert("bb");
//		trie.insert("cc");
//		System.out.println(trie.search("dd"));
//		System.out.println(trie.search("cc"));
//		System.out.println(trie.search("aa"));
//		Trie trie = new Trie();
//		trie.insert("abac");
//		trie.insert("ac");
//		trie.insert("bac");
//		trie.insert("c");
//		trie.insert("algorithm");
//		System.out.println("ab " + trie.search("ab"));
//		System.out.println("bac " + trie.search("bac"));
//		trie.remove("bac");
//		System.out.println("bac " + trie.search("bac"));
//		Iterator<String> list = trie.iterator();
//		while(list.hasNext()) {
//			System.out.println(list.next());
//		}
	}
}

public class Boyer_Moore {
	
	static int skipTable[];
	public static void main(String[] args) {
		skipTable = new int[256];
		String str = "I love you ve move. Plovse, love me.";
		String pattern = "love";
		
		generateSkipTable(pattern, pattern.length());
		int found = search(str, str.length(), 0, pattern, pattern.length());
//		System.out.println(found);
		while (found != -1 && found < str.length()){
			System.out.println(found);
			found = search(str, str.length(), found + pattern.length(), pattern, pattern.length());
		}
		
	}
	static void generateSkipTable(String pattern, int patternLength){
		for (int i = 0; i < 256; i++)
			skipTable[i] = pattern.length();
		for (int i = 0; i < pattern.length(); i++)
			skipTable[pattern.charAt(i)] = pattern.length() - 1 - i;
	}
	
	static int strcmp(String str, int str_index, String pattern, int pattern_length){
		int index = pattern_length - 1;
		while (index >= 0 && str.charAt(str_index) == pattern.charAt(index)  ){
			str_index--;
			index--;
		}
		return index;
	}
	
	static int search(String str, int str_length, int start_index, String pattern, int pattern_length){
		int index = start_index + pattern.length() - 1; //starting point
		while (index < str_length){
			if (str.charAt(index) == pattern.charAt(pattern.length() - 1)){
				int p_index = strcmp(str, index, pattern, pattern_length);
				if (p_index == -1){
					return index - pattern_length + 1; //found
				}
				index = index - pattern_length + 1 + p_index; //틀린 문자가 있는 위치
			}
			index = index + skipTable[str.charAt(index)];	//틀린 문자에 해당되는 거리만큼 jump
		}
		return -1; //not found
	}
}

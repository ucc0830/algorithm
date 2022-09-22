

public class Lottos {

	public static void main(String[] args) {
		
	}

    public int[] solution(int[] lottos, int[] win_nums) {
        
        // 알 수 없는 로또 번호 - 0
		int cnt = 0;
		int joker = 0;
		    		
//		for(int i =0;i<lottos.length;i++) {
//			if(lottos[i] == 0) {
//				joker++;
//			}
//		}
		
		for(int i : lottos) {
			if (i == 0) {
				joker++;
				continue;
			}
			for	(int j : win_nums) {
				if(i == j) {
					cnt++;
				}
			}
		}
		
		int maxRank = getGrade(joker+cnt);
		int minRank = getGrade(cnt);
		
		return new int[] {maxRank,minRank};
		
//		if (joker == 6) {
//			answer[0]=1;
//			answer[1]=6;
//		}
//		else if(joker + cnt == 6) {
//			answer[0] = 1;
//			answer[1] = 7-cnt;
//			if(cnt == 0 ) answer[1] = 6;
//		}
//		else if (joker + cnt == 5) {
//			answer[0] = 2;
//			answer[1] = 7-cnt;   			
//			if(cnt == 0 ) answer[1] = 6;
//		}
//		else if (joker + cnt == 4) {
//			answer[0] = 3;
//			answer[1] = 7-cnt;   			
//			if(cnt == 0 ) answer[1] = 6;
//		}
//		else if (joker + cnt == 3) {
//			answer[0] = 4;
//			answer[1] = 7-cnt;   			
//			if(cnt == 0 ) answer[1] = 6;
//		}
//		else if (joker + cnt == 2) {
//			answer[0] = 5;
//			answer[1] = 7-cnt;   			
//			if(cnt == 0 ) answer[1] = 6;
//		}else {
//			answer[0] = 6;
//			answer[1] = 6;   			
//		}
//        return answer;
    }
    
    public int getGrade(int n) {
    	switch (n) {
		case 6:
			return 1;
		case 5:
			return 2;
		case 4:
			return 3;
		case 3:
			return 4;
		case 2:
			return 5;
		default:
			return 6;
		}
    }
	
}

import java.io.BufferedReader;
import java.io.InputStreamReader;
// 5550. 나는 개구리로소이다
public class Solution_5550 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= TC; testCase++) {
            String s = br.readLine(); // 5 <= 문자열길이 <= 2,500, 'c', 'r', 'o', 'a', 'k'로만 이루어져있음
             
            int result = 0;
            int[] cnt = new int[5]; // 0c, 1r, 2o, 3a, 4k
            loop:for (int i = 0; i < s.length(); i++) {
                switch (s.charAt(i)) {
                case 'c': // 0 
                    if (cnt[4] >= 1) { // 기존에 울던 개구리있는지
                        cnt[4]--;
                        cnt[0]++;
                    } else { // 울던 개구리 없으면 한마리 울음 추가
                        cnt[0]++;
                    }
                    break;
                case 'r': // 1
                    if (cnt[0] >= 1) { // 기존에 울던 개구리있는지
                        cnt[0]--;
                        cnt[1]++;
                    } else { // 울던 개구리 없으면 오류
                        result = -1;
                        break loop;
                    }
                    break;
                case 'o': // 2
                    if (cnt[1] >= 1) { // 기존에 울던 개구리있는지
                        cnt[1]--;
                        cnt[2]++;
                    } else { // 울던 개구리 없으면 오류
                        result = -1;
                        break loop;
                    }
                    break;
                case 'a': // 3
                    if (cnt[2] >= 1) { // 기존에 울던 개구리있는지
                        cnt[2]--;
                        cnt[3]++;
                    } else { // 울던 개구리 없으면 오류
                        result = -1;
                        break loop;
                    }
                    break;
                case 'k': // 4
                    if (cnt[3] >= 1) { // 기존에 울던 개구리있는지
                        cnt[3]--;
                        cnt[4]++;
                    } else { // 울던 개구리 없으면 오류
                        result = -1;
                        break loop;
                    }
                    break;
                }
            }
             
            // 0,1,2,3 의 개수는 0 이고, 4만 있어야함
            if (result != -1) {
                if (cnt[0] != 0 || cnt[1] != 0 || cnt[2] != 0 || cnt[3] != 0) {
                    result = -1;
                } else {
                    result = cnt[4];
                }
            }
             
            sb.append('#').append(testCase).append(' ').append(result).append('\n');
        } // end of for testCase
        System.out.print(sb);
    } // end of main
} // end of class
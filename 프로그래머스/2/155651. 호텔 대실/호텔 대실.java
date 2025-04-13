import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        List<int[]> times = new ArrayList<>();
        
        for (String[] time : book_time) {
            String[] startSplit = time[0].split(":");
            String[] endSplit = time[1].split(":");
            
            int start = 60 * Integer.parseInt(startSplit[0]) + Integer.parseInt(startSplit[1]);
            int end = 60 * Integer.parseInt(endSplit[0]) + Integer.parseInt(endSplit[1]) + 9;
            
            times.add(new int[] {start, end});
        }
        
        for (int m = 0; m < 1440; m++) {
            int cnt = 0;
            for (int[] time : times) {
                if (m >= time[0] && m <= time[1]) cnt++;
            }
            answer = Math.max(answer, cnt);
        }
        
        return answer;
    }
}

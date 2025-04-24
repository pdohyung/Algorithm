import java.util.*;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        int start = 0;
        int end = 10_000;
        
        while (start <= end) {
            int mid = (start + end) / 2;
            int cnt = 0;
            
            for (int c : citations) {
                if (c >= mid) {
                    cnt++;
                }
            }
            
            if (cnt >= mid) {
                start = mid + 1;
            } else { 
                end = mid - 1;
            }
        }
        
        return end;
    }
}

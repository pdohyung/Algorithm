import java.util.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        Arrays.sort(rocks);
        int len = rocks.length;
        int start = 1;
        int end = distance;
        
        while (start <= end) {
            int mid = (start + end) / 2;
            int before = 0;
            int cnt = 0;
            
            for (int i = 0; i < len; i++) {
                if (rocks[i] - before < mid) {
                    cnt++;
                } else {
                    before = rocks[i];
                }
            }
            
            if (distance - before < mid) cnt++;
            
            if (cnt > n) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        
        return end;
    }
}

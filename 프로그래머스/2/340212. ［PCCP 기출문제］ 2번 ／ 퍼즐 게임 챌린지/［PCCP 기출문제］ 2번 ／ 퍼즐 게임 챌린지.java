import java.util.*;

class Solution {
    int diff;
    long l;
    
    public int solution(int[] diffs, int[] times, long limit) {
        l = limit;
        for (int i = 1; i < times.length; i++) diff = Math.max(diff, diffs[i]);
        
        return bs(diffs, times);
    }
    
    private int bs(int[] diffs, int[] times) {
        int start = 1;
        int end = diff;
        
        while (start <= end) {
            int mid = (start + end) / 2;
            long result = 0;
            
            for (int i = 0; i < times.length; i++) {
                if (diffs[i] > mid && i != 0) {
                    result += (diffs[i] - mid) * (times[i - 1] + times[i]) + times[i];
                } else {
                    result += times[i];
                }
            }
            
            if (result > l) start = mid + 1;
            else end = mid - 1;
        }
        
        return start;
    }
}

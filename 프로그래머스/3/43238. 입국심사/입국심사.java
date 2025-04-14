import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        long start = 0;
        long end = (long) times[times.length - 1] * n;
        
        return bs(start, end, n, times);
    }
    
    private long bs(long start, long end, int n, int[] times) {
        while (start <= end) {
            long mid = (start + end) / 2;
            long sum = 0;
            
            for (int i = 0; i < times.length; i++) {
                sum += mid / times[i];
            }
            
            if (sum < n) start = mid + 1;
            else end = mid - 1;
        }
        
        return start;
    }
}

import java.util.*;

class Solution {
    public long solution(int r1, int r2) {
        long rr1 = (long) r1 * r1;
        long rr2 = (long) r2 * r2;
        long answer = 0;
        
        for (long x = 1; x <= r2; x++) {
            long maxY = (long) Math.floor(Math.sqrt(rr2 - x * x));
            long minY = (long) Math.ceil(Math.sqrt(rr1 - x * x));
            answer += maxY - minY + 1;
        }
        
        return answer * 4;
    }
}

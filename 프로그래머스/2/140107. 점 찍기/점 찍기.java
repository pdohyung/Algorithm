import java.util.*;

class Solution {
    public long solution(int k, int d) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i <= d; i += k) numbers.add(i);
        
        long answer = 0;
        int len = numbers.size();
        
        for (int i = 0; i < len; i++) {
            int now = numbers.get(i);
            int target = (int) (Math.sqrt((long) d * d - (long) now * now));
            answer += (target / k) + 1;
        }
        
        return answer;
    }
}

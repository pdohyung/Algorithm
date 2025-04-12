import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(a, b));
        for (int s : scoville) pq.offer(s);
        int cnt = 0;
        
        while (!pq.isEmpty()) {
            if (pq.peek() >= K) break;
            if (pq.size() < 2) {
                cnt = -1;
                break;
            }
            
            int s1 = pq.poll();
            int s2 = pq.poll();
            int sum = s1 + s2 * 2;
            cnt++;
            
            pq.offer(sum);
        }
        
        return cnt;
    }
}

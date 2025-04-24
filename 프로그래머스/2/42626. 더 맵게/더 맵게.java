import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {    
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int s : scoville) {
            pq.offer(s);
        }
        
        int cnt = 0;
        
        while (pq.size() >= 2) {
            if (pq.peek() >= K) break;
            cnt++;
            
            int s1 = pq.poll();
            int s2 = pq.poll();
            int sum = s1 + s2 * 2;
            
            pq.offer(sum);
        }
        
        if (pq.peek() < K) return -1;
        else return cnt;
    }
}

import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        for (int[] r : routes) pq.offer(r);
        
        int cnt = 1;
        int last = pq.peek()[1];
        
        while (!pq.isEmpty()) {
            int[] now = pq.poll();
            
            if (now[0] > last) {
                cnt++;
                last = now[1];
            } 
        }
        
        return cnt;
    }
}

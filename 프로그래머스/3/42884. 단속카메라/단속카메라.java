import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        for (int[] r : routes) pq.offer(r);
        
        int before = Integer.MIN_VALUE;
        
        while (!pq.isEmpty()) {
            int[] now = pq.poll();
            
            if (now[0] > before) {
                answer++;
                before = now[1];
            }
        }
        
        return answer;
    }
}

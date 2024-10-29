import java.util.*;
import java.io.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i = 0; i < works.length; i++) {
            pq.offer(works[i]);
        }
        
        for(int i = 0; i < n; i++) {
            int work = pq.poll();
            
            if(work == 0) break;
            
            work--;
            pq.offer(work);
        }
        
        while(!pq.isEmpty()) {
            int work = pq.poll();
            answer += work * work;
        }
        
        return answer;
    }
}
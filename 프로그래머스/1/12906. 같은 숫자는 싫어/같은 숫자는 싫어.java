import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Queue<Integer> q = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        for (int n : arr) q.offer(n);
        
        int before = -1;
        
        while (!q.isEmpty()) {
            int now = q.poll();
            
            if (before == now) continue;
            
            result.add(now);
            before = now;
        }
        
        int[] answer = new int[result.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }
}

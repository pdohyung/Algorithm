import java.util.*;

class Solution {
    public int solution(int[] cards) {
        boolean[] visited = new boolean[cards.length];
        List<Integer> result = new ArrayList<>();
        
        while (true) {
            int target = 0;
            int now = 0;
            int cnt = 0;
            
            for (int i = 0; i < cards.length; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    target = i + 1;
                    now = cards[i];
                    break;
                } else cnt++;
            }
            
            if (cnt == cards.length) break;
            
            List<Integer> group = new ArrayList<>();
            group.add(now);
            
            while (now != target) {
                visited[now - 1] = true;
                now = cards[now - 1];
                group.add(now);
            }
            
            result.add(group.size());
        }
        
        Collections.sort(result, Collections.reverseOrder());
        
        int max = 0;
        if (result.size() == 1) max = 0;
        else max = result.get(0) * result.get(1);
        
        return max;
    }
}

import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        Set<String> all = new HashSet<>();
        for (String gem : gems) all.add(gem);
        
        int len = gems.length;
        int start = 0;
        int end = 0;
        int[] answer = {1, len};
        int min = len;
        Set<String> set = new HashSet<>();
        Map<String, Integer> map = new HashMap<>();
        
        while (start < len) {
            while (end < len && set.size() < all.size()) {
                String gem = gems[end];
                set.add(gem);
                map.put(gem, map.getOrDefault(gem, 0) + 1);
                end++;
            }
            
            if (set.size() == all.size() && min > end - start) {
                min = end - start;
                answer[0] = start + 1;
                answer[1] = end;
            }
            
            String gem = gems[start];
            int now = map.get(gem) - 1;
            map.put(gem, now);
            if (now == 0) set.remove(gem);
            start++;
        }
        
        return answer;
    }
}

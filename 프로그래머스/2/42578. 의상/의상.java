import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        
        for (String[] s : clothes) {
            String name = s[0];
            String type = s[1];
            map.put(type, map.getOrDefault(type, 0) + 1);
        }
        
        int answer = 1;
        for (String key : map.keySet()) answer *= map.get(key) + 1;
        
        return answer - 1;
    }
}

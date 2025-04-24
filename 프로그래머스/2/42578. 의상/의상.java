import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> types = new HashMap<>();
        
        for (String[] c : clothes) {
            types.put(c[1], types.getOrDefault(c[1], 0) + 1);
        }
        
        int answer = 1;
        
        for (String key : types.keySet()) {
            answer *= types.get(key) + 1;
        }
        
        return answer - 1;
    }
}

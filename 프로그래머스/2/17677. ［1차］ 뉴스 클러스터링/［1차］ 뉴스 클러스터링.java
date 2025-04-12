import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        Set<String> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < str1.length() - 1; i++) {
            char c1 = str1.charAt(i);
            char c2 = str1.charAt(i + 1);
            
            if (Character.isLetter(c1) && Character.isLetter(c2)) {
                sb.append(Character.toLowerCase(c1)).append(Character.toLowerCase(c2));
                String key = sb.toString();
                set.add(key);
                map1.put(key, map1.getOrDefault(key, 0) + 1);   
                sb = new StringBuilder();
            }
        }
        
        for (int i = 0; i < str2.length() - 1; i++) {
            char c1 = str2.charAt(i);
            char c2 = str2.charAt(i + 1);
            
            if (Character.isLetter(c1) && Character.isLetter(c2)) {
                sb.append(Character.toLowerCase(c1)).append(Character.toLowerCase(c2));
                String key = sb.toString();
                set.add(key);
                map2.put(key, map2.getOrDefault(key, 0) + 1);
                sb = new StringBuilder();
            }
        }
        
        double A = 0;
        double B = 0;
        
        for (String k : set) {
            if (map1.containsKey(k) && map2.containsKey(k)) {
                A += Math.min(map1.get(k), map2.get(k));
                B += Math.max(map1.get(k), map2.get(k));
            } else {
                if (map1.containsKey(k)) B += map1.get(k);
                else B += map2.get(k);
            }
        }
        
        if (B == 0) return 65536;
        else return (int) (A / B * 65536);
    }
}

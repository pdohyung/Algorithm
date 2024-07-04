import java.util.*;
import java.io.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        LinkedList<String> cache = new LinkedList<>();
        
        if (cacheSize == 0) {
            return cities.length * 5;
        }
        
        for (String s : cities) {
            String city = s.toUpperCase();
            
            if (cache.contains(city)) {
                cache.remove(city);
                cache.add(city);
                answer += 1;
            }

            else {
                if (cache.size() == cacheSize){ 
                    cache.remove(0); 
                }
                cache.add(city);
                answer += 5;
            }
            //System.out.println(Arrays.toString(cache.toArray()));
        }
        return answer;
    }
}
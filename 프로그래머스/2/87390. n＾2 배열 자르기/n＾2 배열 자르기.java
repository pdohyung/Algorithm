import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int n, long left, long right) {
        List<Integer> result = new ArrayList<>();
        
        for (long i = left; i <= right; i++) {
            int x = (int) (i / n);
            int y = (int) (i % n);
            
            if (x >= y) {
                result.add(x + 1);
            } else {
                result.add(y + 1);                
            }
        }
        
        return result.stream().mapToInt(i -> i).toArray();
    }
}

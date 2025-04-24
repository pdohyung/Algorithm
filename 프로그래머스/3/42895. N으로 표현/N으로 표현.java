import java.util.*;

class Solution {
    public int solution(int N, int number) {
        List<Set<Integer>> list = new ArrayList<>();
        for (int i = 0; i <= 8; i++) list.add(new HashSet<>());
        String start = "";
        
        for (int i = 1; i <= 8; i++) {
            Set<Integer> now = list.get(i);
            start += String.valueOf(N);
            now.add(Integer.parseInt(start));
            
            for (int j = 1; j < i; j++) {
                Set<Integer> aSet = list.get(j);
                Set<Integer> bSet = list.get(i - j);
                
                for (int a : aSet) {
                    for (int b : bSet) {
                        now.add(a + b);
                        now.add(a - b);
                        now.add(a * b);
                        if (b != 0) now.add(a / b);
                    }
                }
                
            }
            
            if (now.contains(number)) {
                return i;
            }
        }
        
        return -1;
    }
}

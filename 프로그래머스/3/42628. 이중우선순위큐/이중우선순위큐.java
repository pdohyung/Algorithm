import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        Map<Integer, Integer> map = new HashMap<>();
        TreeSet<Integer> set = new TreeSet<>();
        
        for (int o = 0; o < operations.length; o++) {
            String[] split = operations[o].split(" ");
            String type = split[0];
            int num = Integer.parseInt(split[1]);
            
            if (type.equals("D") && num == -1) {
                if (set.isEmpty()) continue;
                int now = map.get(set.first()) - 1;
                map.put(set.first(), now);
                if (now == 0) set.pollFirst();
            } else if (type.equals("D") && num == 1) {
                if (set.isEmpty()) continue;
                int now = map.get(set.last()) - 1;
                map.put(set.last(), now);
                if (now == 0) set.pollLast();
            } else {
                set.add(num);
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }
        
        if (set.isEmpty()) {
            return new int[] {0, 0};
        } else {
            return new int[] {set.last(), set.first()};
        }
    }
}

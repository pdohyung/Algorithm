import java.util.*;

class Solution {
    public int[] solution(int[][] edges) {
        Map<Integer, Integer> in = new HashMap<>();
        Map<Integer, Integer> out = new HashMap<>();
        int[] answer = new int[4];
        
        for (int[] edge : edges) {
            in.put(edge[1], in.getOrDefault(edge[1], 0) + 1);
            out.put(edge[0], out.getOrDefault(edge[0], 0) + 1);
        }
        
        for (int key : out.keySet()) {
            if (out.get(key) > 1) {
                if (!in.containsKey(key)) {
                    answer[0] = key;
                } else {
                    answer[3]++;
                }
            }
        }
        
        for (int key : in.keySet()) {
            if (!out.containsKey(key)) {
                answer[2]++;
            }
        }
        
        answer[1] = out.get(answer[0]) - answer[2] - answer[3];
        
        return answer;
    }
}

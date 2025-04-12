import java.util.*;

class Solution {
    
    List<int[]> result;
    
    public int[][] solution(int n) {
        result = new ArrayList<>();
        move(n, 1, 3, 2);
        
        int[][] answer = new int[result.size()][2];
        for (int i = 0; i < result.size(); i++) answer[i] = result.get(i);
        
        return answer;
    }
    
    void move(int now, int from, int to, int via) {
        if (now == 0) return;
        
        move(now - 1, from, via, to);
        result.add(new int[] {from, to});
        move(now - 1, via, to, from);
    }
}

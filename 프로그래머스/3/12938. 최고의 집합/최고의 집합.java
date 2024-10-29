import java.util.*;

class Solution {
    public int[] solution(int n, int s) {
        int[] answer = new int[n];
        int d = s / n;
        int m = s % n;
        
        if (d == 0) {
            return new int[]{-1};
        }
        
        for(int i = 0; i < n; i++) {
            answer[i] = d; 
        }
        
        for(int i = 0; i < m; i++) {
            answer[i] += 1; 
        }
        
        Arrays.sort(answer);
        
        return answer;
    }
}

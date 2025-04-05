import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int max = 0;
        for (int t : tangerine) max = Math.max(max, t);
        int[] A = new int[max];
        for (int t : tangerine) A[t - 1]++;
        
        Arrays.sort(A);
        int now = 0;
        int answer = 0;
        
        for (int i = A.length - 1; i >= 0; i--) {
            now += A[i];
            answer++;
            if (now >= k) break; 
        }
        
        return answer;
    }
}

import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 1;
        
        for (int i = 1; i <= n; i++) {
            int sum = 0;
            for (int j = i; j <= n; j++) {
                if (sum == n) {
                    answer++;
                    break;
                }
                else if (sum > n) break;
                else sum += j;
                
            }
        }
        
        return answer;
    }
}

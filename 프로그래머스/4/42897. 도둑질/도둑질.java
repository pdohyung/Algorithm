import java.util.*;

class Solution {
    public int solution(int[] money) {
        int len = money.length;
        
        int[] dp = new int[len + 1];
        dp[1] = money[0];
        for(int i = 2; i < len; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + money[i - 1]);
        }
        
        int answer = dp[len - 1];
        
        dp = new int[len + 1];
        for(int i = 2; i <= len; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + money[i - 1]);
        }
        
        answer = Math.max(answer, dp[len]);
        
        return answer;
    }
}

import java.util.*;

class Solution {
    public long solution(int n) {
        long answer = 0;
        long[] dp = new long[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        
        for (int j = 2; j <= n; j++) {
            dp[j] += (dp[j - 1] + dp[j - 2]) % 1234567;
        }
        
        return dp[n];
    }
}

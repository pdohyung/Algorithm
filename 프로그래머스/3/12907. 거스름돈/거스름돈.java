import java.util.*;

class Solution {
    public int solution(int n, int[] money) {
        // 거스름돈을 주는 경우의 수
        int MOD = 1_000_000_007;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        
        for (int m : money) {
            for (int i = m; i <= n; i++) {
                dp[i] = (dp[i] + dp[i - m]) % MOD;
            }
        }
        
        return dp[n];
    }
}

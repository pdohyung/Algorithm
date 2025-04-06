class Solution {
    public int solution(int n) {
        long MOD = 1_000_000_007;
        long[] dp = new long[n + 1];
        dp[0] = 1;
        dp[2] = 3;
        long sum = 0;
        
        for (int i = 4; i <= n; i += 2) {
            sum += (dp[i - 4] * 2) % MOD;
            dp[i] = (dp[i - 2] * 3 + sum) % MOD;
        }
        
        return (int) dp[n];
    }
}

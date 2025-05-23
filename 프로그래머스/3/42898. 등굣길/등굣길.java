class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] dp = new int[n + 1][m + 1];
        boolean[][] pass = new boolean[n + 1][m + 1];
        
        for (int[] p : puddles) {
            pass[p[1]][p[0]] = true;
        }
        
        dp[1][1] = 1;
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (pass[i][j]) continue;
                dp[i][j] += (dp[i - 1][j] + dp[i][j - 1]) % 1_000_000_007;
            }
        }
        
        return dp[n][m];
    }
}

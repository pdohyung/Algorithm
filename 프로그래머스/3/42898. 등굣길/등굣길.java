import java.util.*;

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        // 오른쪽과 아래쪽으로만 이동 가능, 최단경로의 개수를 리턴
        int MOD = 1_000_000_007;
        int[][] dp = new int[n + 1][m + 1];
        boolean[][] P = new boolean[n + 1][m + 1];
        
        for (int[] p : puddles) {
            P[p[1]][p[0]] = true;
        }
        
        dp[0][1] = 1;
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (P[i][j]) continue;
                dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % MOD;
            }
        }
        
        return dp[n][m];
    }
}

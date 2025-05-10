import java.util.*;

class Solution {
    public int solution(int[][] info, int n, int m) {
        int INF = 10_000;
        int len = info.length;
        int[][] dp = new int[len + 1][m];
        
        for (int i = 0; i <= len; i++) {
            Arrays.fill(dp[i], INF);
        }
        
        // [i][j] = x, i번째 선물에서 j는 B의 흔적, x는 A의 흔적
        dp[0][0] = 0;
        
        for (int i = 1; i <= len; i++) {
            int a = info[i - 1][0];
            int b = info[i - 1][1];
            
            for (int j = 0; j < m; j++) {
                // A 갱신
                dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + a);
                
                // B 갱신
                if (j + b < m) {
                    dp[i][j + b] = Math.min(dp[i][j + b], dp[i - 1][j]);
                }
            }
        }
        
        int min = INF;
        for (int j = 0; j < m; j++) {
            min = Math.min(min, dp[len][j]);
        }
        
        return min < n ? min : -1;
    }
}

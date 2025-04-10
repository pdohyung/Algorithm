import java.util.*;

class Solution {
    int solution(int[][] land) {
        int answer = 0;
        int h = land.length;
        int[][] dp = new int[h + 1][4];
        
        for (int i = 1; i <= h; i++) {
            dp[i][0] = Math.max(dp[i - 1][1], Math.max(dp[i - 1][2], dp[i - 1][3])) + land[i - 1][0];
            dp[i][1] = Math.max(dp[i - 1][0], Math.max(dp[i - 1][2], dp[i - 1][3])) + land[i - 1][1];
            dp[i][2] = Math.max(dp[i - 1][0], Math.max(dp[i - 1][1], dp[i - 1][3])) + land[i - 1][2];
            dp[i][3] = Math.max(dp[i - 1][0], Math.max(dp[i - 1][1], dp[i - 1][2])) + land[i - 1][3];
        }
        
        for (int i = 0; i < 4; i++) answer = Math.max(answer, dp[h][i]);
        
        return answer;
    }
}

import java.util.*;

class Solution {
    public int solution(int sticker[]) {
        int len = sticker.length;
        int[][] dp = new int[len + 1][2];
        
        // 1번째를 선택한 경우
        dp[1][0] = 0;
        dp[1][1] = sticker[0];
        
        int answer = dp[1][1];
        
        for (int i = 2; i < len; i++) {
            dp[i][0] = dp[i - 1][1];
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + sticker[i - 1]);
        }
        
        answer = Math.max(answer, Math.max(dp[len - 1][0], dp[len - 1][1]));
        dp = new int[len + 1][2];
        
        // 1번째를 선택하지 않은 경우
        dp[1][0] = 0;
        dp[1][1] = 0;
        
        for (int i = 2; i <= len; i++) {
            dp[i][0] = dp[i - 1][1];
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + sticker[i - 1]);
        }
        
        answer = Math.max(answer, Math.max(dp[len][0], dp[len][1]));

        return answer;
    }
}

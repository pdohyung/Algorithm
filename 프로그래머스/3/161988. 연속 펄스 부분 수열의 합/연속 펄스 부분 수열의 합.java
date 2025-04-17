import java.util.*;

class Solution {
    public long solution(int[] sequence) {
        // 펄스 수열의 두가지 종류, -1부터 시작 / 1부터 시작
        long answer = 0;
        int len = sequence.length;
        
        long[] type1 = new long[len];
        long[] type2 = new long[len];
        
        int n = 1;
        for (int i = 0; i < len; i++) {
            type1[i] = sequence[i] * n;
            n *= -1;
        }
        
        n = -1;
        for (int i = 0; i < len; i++) {
            type2[i] = sequence[i] * n;
            n *= -1;
        }
        
        long[] dp = new long[len + 1];
        
        for (int i = 1; i <= len; i++) {
            dp[i] = type1[i - 1];
            if (dp[i - 1] > 0) dp[i] += dp[i - 1];
            answer = Math.max(answer, dp[i]);
        }
        
        dp = new long[len + 1];
        
        for (int i = 1; i <= len; i++) {
            dp[i] = type2[i - 1];
            if (dp[i - 1] > 0) dp[i] += dp[i - 1];
            answer = Math.max(answer, dp[i]);
        }
        
        return answer;
    }
}

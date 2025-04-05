import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[][] triangle) {
        int size = triangle.length;
        int[][] dp = new int[size][size];
        
        // 바텀업을 위한 가장 아래 배열 초기화
        for (int i = 0; i < size; i++) dp[size - 1][i] = triangle[size - 1][i];
        
        for (int i = size - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                int now = Math.max(dp[i + 1][j], dp[i + 1][j + 1]) + triangle[i][j];
                dp[i][j] = Math.max(dp[i][j], now);
            }
        }
        
        return dp[0][0];
    }
}

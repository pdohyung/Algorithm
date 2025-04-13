import java.util.*;

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int MOD = 1_000_000_007;
        int[][] map = new int[n + 1][m + 1];
        for (int[] p : puddles) map[p[1]][p[0]] = -1;
        
        if (m > 1 && map[1][2] != -1) map[1][2] = 1;
        if (n > 1 && map[2][1] != -1) map[2][1] = 1;
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (map[i][j] == -1) continue;
                
                if (map[i - 1][j] != -1) map[i][j] = (map[i][j] + map[i - 1][j]) % MOD;
                if (map[i][j - 1] != -1) map[i][j] = (map[i][j] + map[i][j - 1]) % MOD;
            }
        }
        
        return map[n][m];
    }
}

import java.util.*;

class Solution {
    public int solution(int n, int[][] results) {
        int[][] graph = new int[n + 1][n + 1];
        
        for (int[] r : results) {
            int win = r[0];
            int lose = r[1];
            graph[win][lose] = 1;
            graph[lose][win] = -1;
        }
        
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (graph[i][k] == 1 && graph[k][j] == 1) graph[i][j] = 1;
                    if (graph[i][k] == -1 && graph[k][j] == -1) graph[i][j] = -1;
                }
            }
        }
        
        int answer = 0;
        
        for (int i = 1; i <= n; i++) {
            int cnt = 0;
            
            for (int j = 1; j <= n; j++) {
                if (graph[i][j] != 0) cnt++;
            }
            
            if (cnt == n - 1) answer++;
        }
        
        return answer;
    }
}

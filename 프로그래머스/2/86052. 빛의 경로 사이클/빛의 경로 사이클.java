import java.io.*;
import java.util.*;

class Solution {
    
    static String[] G;
    static int n, m;
    static boolean[][][] visited;
    static int[] dx = {-1, 0, 1, 0}; // 상우하좌
    static int[] dy = {0, 1, 0, -1};
    
    public int[] solution(String[] grid) {
        G = grid;
        n = grid.length;
        m = grid[0].length();
        List<Integer> result = new ArrayList<>();
        
        visited = new boolean[n][m][4];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int d = 0; d < 4; d++) {
                    if (visited[i][j][d]) continue;
                    result.add(dfs(i, j, d));
                }
            }
        }
        Collections.sort(result);
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
    
    int dfs(int i, int j, int d) {
        int cnt = 0;
        
        while (!visited[i][j][d]) {
            visited[i][j][d] = true;
            
            // 다음 방향 결정
            if (G[i].charAt(j) == 'S') {
            } else if (G[i].charAt(j) == 'L') {
                d = (d + 1) % 4; 
            } else {
                d = (d - 1 + 4) % 4;
            }
            
            // 다음 좌표 계산
            i = i + dx[d];
            j = j + dy[d];
            
            // 경계 처리
            i = (i + n) % n;
            j = (j + m) % m;
            
            cnt++;
        }
        
        return cnt;
    }
}

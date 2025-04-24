import java.util.*;

class Node {
    int x, y;
    
    Node (int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Solution {
    
    int n, m;
    int[][] map;
    int[] dx = {0, 0, -1, 1};
    int[] dy = {-1, 1, 0, 0};
    
    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                maps[i][j]--;
            }
        }
        
        map = maps;
        bfs(new Node(0, 0));
        
        if (map[n - 1][m - 1] == 0) return -1;
        else return map[n - 1][m - 1];
    }
    
    void bfs(Node start) {
        Queue<Node> q = new ArrayDeque<>();
        q.offer(start);
        map[start.x][start.y] = 1;
        
        while (!q.isEmpty()) {
            Node now = q.poll();
            int x = now.x;
            int y = now.y;
            
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (nx < 0 || nx >= n || ny < 0 || ny >= m || map[nx][ny] != 0) continue;
                
                map[nx][ny] = map[x][y] + 1;
                q.offer(new Node(nx, ny));
            }
        }
    }
}

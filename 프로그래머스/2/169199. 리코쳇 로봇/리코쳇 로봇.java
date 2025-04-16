import java.util.*;

class Node {
    int x, y, cnt;
    
    Node(int x, int y, int cnt) {
        this.x = x;
        this.y = y;
        this.cnt = cnt;
    }
}

class Solution {
    public int solution(String[] board) {
        int answer = 0;
        int n = board.length;
        int m = board[0].length();
        int sx = 0;
        int sy = 0;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        
        char[][] map = new char[n][m];
        boolean[][] visited = new boolean[n][m];
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                map[i][j] = board[i].charAt(j);
                if (map[i][j] == 'R') {
                    sx = i;
                    sy = j;
                }
            }
        }
        
        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node(sx, sy, 0));
        visited[sx][sy] = true;
        
        while (!q.isEmpty()) {
            Node now = q.poll();
            int x = now.x;
            int y = now.y;
            int cnt = now.cnt;
            
            if (map[x][y] == 'G') return cnt;

            for (int i = 0; i < 4; i++) {
                int nx = x;
                int ny = y;
                
                while (true) {
                    int tx = nx + dx[i];
                    int ty = ny + dy[i];

                    if (tx < 0 || tx >= n || ty < 0 || ty >= m || map[tx][ty] == 'D') break;

                    nx = tx;
                    ny = ty;
                }
                
                if (!visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.offer(new Node(nx, ny, cnt + 1));
                }
            }
        }
        
        return -1;
    }
}

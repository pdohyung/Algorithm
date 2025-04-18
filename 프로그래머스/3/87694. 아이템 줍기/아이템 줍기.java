import java.util.*;

class Node {
    int x, y, cnt;
    
    Node (int x, int y, int cnt) {
        this.x = x;
        this.y = y;
        this.cnt = cnt;
    }
}

class Solution {
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int[][] map = new int[101][101];
        boolean[][] visited = new boolean[101][101];
        
        for (int[] r : rectangle) {
            int x1 = r[0] * 2;
            int y1 = r[1] * 2;
            int x2 = r[2] * 2;
            int y2 = r[3] * 2;
            
            for (int x = x1; x <= x2; x++) {
                for (int y = y1; y <= y2; y++) {
                    map[x][y] = 1;
                }
            }
        }
        
        for (int[] r : rectangle) {
            
            int x1 = r[0] * 2;
            int y1 = r[1] * 2;
            int x2 = r[2] * 2;
            int y2 = r[3] * 2;
            
            for (int x = x1 + 1; x < x2; x++) {
                for (int y = y1 + 1; y < y2; y++) {
                    map[x][y] = 0;
                }
            }
        }
        
        int answer = 0;
        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node(characterX * 2, characterY * 2, 0));
        visited[characterX * 2][characterY * 2] = true;
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        
        while(!q.isEmpty()) {
            Node now = q.poll();
            int x = now.x;
            int y = now.y;
            int cnt = now.cnt;
            
            if (x == itemX * 2 && y == itemY * 2) {
                answer = cnt;
                break;
            }
            
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (nx < 1 || nx > 100 || ny < 1 || ny > 100 || map[nx][ny] == 0 || visited[nx][ny]) continue;
                
                q.add(new Node(nx, ny, cnt + 1));
                visited[nx][ny] = true;
            }
        }
        
        return answer / 2;
    }
}

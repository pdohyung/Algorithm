import java.util.*;

class Node {
    int x, y;
    
    Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Solution {
    
    int n, m;
    char[][] map;
    boolean[][] visited;
    int[] dx = {0, 0, -1, 1};
    int[] dy = {-1, 1, 0, 0};
    
    public int solution(String[] storage, String[] requests) {
        n = storage.length;
        m = storage[0].length();
        map = new char[n][m];
        visited = new boolean[n][m];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = storage[i].charAt(j);
            }
        }
        
        for (String r : requests) {
            char t = r.charAt(0);
            List<Node> nodes = new ArrayList<>();
            
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (!visited[i][j] && map[i][j] == t) {
                        nodes.add(new Node(i, j));
                    }
                }
            }
            
            if (r.length() == 1) {
                List<Node> result = new ArrayList<>();
                
                for (Node node : nodes) {
                    if (bfs(node)) {
                        result.add(node);
                    }
                }
                
                nodes = result;
            }
            
            for (Node node : nodes) {
                visited[node.x][node.y] = true;
            }
        }
        
        int answer = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j]) {
                    answer++;
                }
            }
        }
        
        return answer;
    }
    
    boolean bfs(Node start) {
        Queue<Node> q = new LinkedList<>();
        q.offer(start);
        boolean[][] pass = new boolean[n][m];
        pass[start.x][start.y] = true;
        
        while (!q.isEmpty()) {
            Node now = q.poll();
            int x = now.x;
            int y = now.y;
            
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) return true;
                if (!visited[nx][ny] || pass[nx][ny]) continue;
                
                pass[nx][ny] = true;
                q.offer(new Node(nx, ny));
            }
        }
        
        return false;
    }
}

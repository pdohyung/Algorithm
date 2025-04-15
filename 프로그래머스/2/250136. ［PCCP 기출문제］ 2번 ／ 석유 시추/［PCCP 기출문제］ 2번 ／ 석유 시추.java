import java.util.*;

class Node {
    int x, y;
    
    Node (int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Solution {
    
    boolean[][] visited;
    int h, w;
    int[] dx = {0, 0, -1, 1};
    int[] dy = {-1, 1, 0, 0};
    int[] result;
    
    public int solution(int[][] land) {
        h = land.length;
        w = land[0].length;
        visited = new boolean[h][w];
        result = new int[w];
        
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (visited[i][j] || land[i][j] != 1) continue;
                bfs(new Node(i, j), land);
            }
        }
        
        int answer = 0;
        
        for (int r : result) {
            answer = Math.max(answer, r);
        }
        
        return answer;
    }
    
    private void bfs(Node start, int[][] land) {
        Queue<Node> q = new ArrayDeque<>();
        q.add(start);
        visited[start.x][start.y] = true;
        Set<Integer> targets = new HashSet<>();
        targets.add(start.y);
        int sum = 1;
        
        while(!q.isEmpty()) {
            Node now = q.poll();
            int x = now.x;
            int y = now.y;
            
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (nx < 0 || nx >= h || ny < 0 || ny >= w) continue;
                if (visited[nx][ny] || land[nx][ny] != 1) continue;
                
                sum++;
                visited[nx][ny] = true;
                targets.add(ny);
                q.add(new Node(nx, ny));
            }
        }
        
        for (int t : targets) {
            result[t] += sum;
        }
    }
}

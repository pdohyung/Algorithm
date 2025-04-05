import java.util.*;

class Node {
    int x, y;
    
    Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Solution {
    
    private int w, h;
    private int[][] map;
    private boolean[][] visited;
    private int[] dx = {-1, 1, 0, 0};
    private int[] dy = {0, 0, -1, 1};
    
    public int[] solution(String[] maps) {
        w = maps[0].length();
        h = maps.length;
        map = new int[h][w];
        
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (maps[i].charAt(j) == 'X') map[i][j] = 0;
                else map[i][j] = maps[i].charAt(j) - 48;
            }
        }
        
        List<Integer> result = new ArrayList<>();
        visited = new boolean[h][w];
        
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (visited[i][j] || map[i][j] == 0) continue;
                int r = bfs(new Node(i, j));
                if (r == 0) continue;
                result.add(r);
            }
        }
        
        Collections.sort(result);
        
        if (result.isEmpty()) return new int[] {-1};
        
        int[] answer = new int[result.size()];
        for (int i = 0; i < answer.length; i++) answer[i] = result.get(i);
        return answer;
    }
    
    private int bfs(Node start) {
        Queue<Node> q = new ArrayDeque<>();
        q.add(start);
        visited[start.x][start.y] = true;
        int sum = map[start.x][start.y];
        
        while(!q.isEmpty()) {
            Node now = q.poll();
            int x = now.x;
            int y = now.y;
            
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (nx < 0 || nx >= h || ny < 0 || ny >= w) continue;
                if (visited[nx][ny] || map[nx][ny] == 0) continue;
                
                sum += map[nx][ny];
                visited[nx][ny] = true;
                q.add(new Node(nx, ny));
            }
        }
        
        return sum;
    }
}

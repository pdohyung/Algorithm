import java.util.*;

class Node {
    private final int x;
    private final int y;
    
    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public int getX() {
        return this.x;
    }
    
    public int getY() {
        return this.y;
    }
}

class Solution {
    
    static int[] dx = { 0, 1, 0, -1 };
    static int[] dy = { 1, 0, -1, 0 };
    static int[][] inputMaps;
    static boolean[][] visit;
    static int n, m, answer;
    
    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;
        inputMaps = maps;
        visit = new boolean[n][m];
        
        bfs(new Node(0, 0));
        
        if(inputMaps[n - 1][m - 1] == 1) {
            answer = -1;
        } else {
            answer = inputMaps[n-1][m-1];
        }
        return answer;
    }
    
    private void bfs(Node node) {
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        visit[node.getX()][node.getY()] = true;
        
        while(!q.isEmpty()) {
            Node newNode = q.poll();
            for(int i = 0; i < 4; i++) {
                int nx = newNode.getX() + dx[i];
                int ny = newNode.getY() + dy[i];
                
                if (ny < 0 || ny >= m || nx < 0 || nx >= n) continue;
                if (visit[nx][ny] || inputMaps[nx][ny] == 0) continue;
                
                inputMaps[nx][ny] = inputMaps[newNode.getX()][newNode.getY()] + 1;
                visit[nx][ny] = true;
                q.add(new Node(nx, ny));
                
            }
        }
    }
}
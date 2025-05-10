import java.util.*;

class Node {
    int x, y;
    
    Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Solution {
    
    int M, N;
    int[][] P;
    boolean[][] visited;
    int[] dx = {0, 0, -1, 1};
    int[] dy = {-1, 1, 0, 0};
    
    public int[] solution(int m, int n, int[][] picture) {
        // 0이 아니면서 방문하지 않은 영역을 탐색
        M = m;
        N = n;
        P = picture;
        visited = new boolean[M][N];
        int cnt = 0;
        int max = 0;
        
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (P[i][j] > 0 && !visited[i][j]) {
                    cnt++;
                    max = Math.max(max, bfs(new Node(i, j)));
                }
            }
        }

        return new int[] {cnt, max};
    }
    
    int bfs(Node start) {
        Queue<Node> q = new LinkedList<>();
        q.offer(start);
        visited[start.x][start.y] = true;
        int size = 1;
        
        while (!q.isEmpty()) {
            Node now = q.poll();
            int x = now.x;
            int y = now.y;
            
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (nx < 0 || nx >= M || ny < 0 || ny >= N) continue;
                if (visited[nx][ny] || P[x][y] != P[nx][ny]) continue;
                
                visited[nx][ny] = true;
                q.offer(new Node(nx, ny));
                size++;
            }
        }
        
        return size;
    }
}

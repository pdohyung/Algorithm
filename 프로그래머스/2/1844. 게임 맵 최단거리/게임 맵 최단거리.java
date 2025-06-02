import java.util.*;

class Node {
    int x, y;
    
    Node (int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Solution {
    
    int N, M;
    int[][] B;
    int[] dx = {0, 0, -1, 1};
    int[] dy = {-1, 1, 0, 0};
    
    public int solution(int[][] maps) {
        // (1, 1)에서 (N, M)까지 최단거리 구하기
        N = maps.length;
        M = maps[0].length;
        B = new int[N][M];
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (maps[i][j] == 0) {
                    B[i][j] = -1;
                } else {
                    B[i][j] = 0;
                }
            }
        }
        
        bfs(new Node(0, 0));
        
        return B[N - 1][M - 1] == 0 ? -1 : B[N - 1][M - 1];
    }
    
    void bfs(Node start) {
        Queue<Node> q = new LinkedList<>();
        q.offer(start);
        B[start.x][start.y] = 1;
        
        while (!q.isEmpty()) {
            Node now = q.poll();
            int x = now.x;
            int y = now.y;
            
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (nx < 0 || nx >= N || ny < 0 || ny >= M || B[nx][ny] != 0) continue;
                
                B[nx][ny] = B[x][y] + 1;
                q.offer(new Node(nx, ny));
            }
        }
    }
}

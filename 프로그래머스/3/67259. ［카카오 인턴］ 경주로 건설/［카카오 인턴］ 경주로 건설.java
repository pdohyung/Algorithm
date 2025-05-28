import java.util.*;

class Node {
    int x, y, d;
    
    Node(int x, int y, int d) {
        this.x = x;
        this.y = y;
        this.d = d;
    }
}

class Solution {
    
    int N;
    int[][] B;
    int[][][] C;
    
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    
    public int solution(int[][] board) {
        // NxN의 정사각형 격자 형태, 0은 칸이 비어있음, 1은 벽이 채워짐
        // 경주로를 (0,0) 부터 (N-1, N-1)까지 건설하는 최소 비용
        // 코너 부분은 총 600원, 일반은 100원
        N = board.length;
        B = board;
        C = new int[N][N][4];
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                Arrays.fill(C[i][j], Integer.MAX_VALUE);
            }
        }
        
        Arrays.fill(C[0][0], 0);
        bfs();
        
        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < 4; i++) {
            answer = Math.min(answer, C[N - 1][N - 1][i]);
        }
        return answer;
    }
    
    void bfs() {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0, 0, 1)); // 아래
        q.offer(new Node(0, 0, 3)); // 오른쪽
        
        while (!q.isEmpty()) {
            Node now = q.poll();
            int x = now.x;
            int y = now.y;
            int d = now.d;
            
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (nx < 0 || nx >= N || ny < 0 || ny >= N || B[nx][ny] == 1) continue;
                
                if (i == d) {
                    if (C[nx][ny][i] > C[x][y][d] + 100) {
                        C[nx][ny][i] = C[x][y][d] + 100;
                        q.offer(new Node(nx, ny, i));
                    }
                } else {
                    if (C[nx][ny][i] > C[x][y][d] + 600) {
                        C[nx][ny][i] = C[x][y][d] + 600;
                        q.offer(new Node(nx, ny, i));
                    }
                }
            }
        }
    }
}

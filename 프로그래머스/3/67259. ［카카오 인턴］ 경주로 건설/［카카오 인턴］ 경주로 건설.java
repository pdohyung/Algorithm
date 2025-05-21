import java.util.*;

class Node {
    int x, y, d, c;
    
    Node(int x, int y, int d, int c) {
        this.x = x;
        this.y = y;
        this.d = d;
        this.c = c;
    }
}

class Solution {
    public int solution(int[][] board) {
        // 어디 방향에서 도착하냐에 따라 값이 달라질 수 있음.
        int N = board.length;
        int M = board[0].length;
        int[][][] C = new int[N][M][4];
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                Arrays.fill(C[i][j], Integer.MAX_VALUE);
            }
        }
        
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0, 0, 1, 0));
        q.offer(new Node(0, 0, 3, 0));
        Arrays.fill(C[0][0], 0);
        
        while (!q.isEmpty()) {
            Node now = q.poll();
            int x = now.x;
            int y = now.y;
            int d = now.d;
            int c = now.c;
            
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                int next = c;
                
                if (nx < 0 || nx >= N || ny < 0 || ny >= M || board[nx][ny] == 1) continue;
                
                if (d == i) next += 100;
                else next += 600;
                
                if (C[nx][ny][i] > next) {
                    C[nx][ny][i] = next;
                    q.offer(new Node(nx, ny, i, next));
                }
            }
        }
        
        int answer = Integer.MAX_VALUE;
        
        for (int i = 0; i < 4; i++) {
            answer = Math.min(answer, C[N - 1][M - 1][i]);
        }
        
        return answer;
    }
}

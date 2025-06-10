import java.util.*;

class Node {
    int x, y;
    
    Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Solution {
    
    int[][] map;
    boolean[][] redVisited, blueVisited;
    int N, M, answer;
    Node redStart, blueStart, redTarget, blueTarget;
    int[] dx = {0, 0, -1, 1};
    int[] dy = {-1, 1, 0, 0};
    
    public int solution(int[][] maze) {
        // 빨간색, 파란색 수레는 각 자신의 도착 칸까지 이동해야함
        // 벽이나 범위 밖 불가, 자신이 방문했던 칸 불가, 자신의 도착 칸에 위치하면 멈춤
        N = maze.length;
        M = maze[0].length;
        map = new int[N][M];
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int now = maze[i][j];
                if (now == 1) redStart = new Node(i, j);
                else if (now == 2) blueStart = new Node(i, j);
                else if (now == 3) redTarget = new Node(i, j);
                else if (now == 4) blueTarget = new Node(i, j);
                
                if (now == 5) map[i][j] = -1;
                else map[i][j] = 0;
            }
        }
        answer = Integer.MAX_VALUE;
        
        redVisited = new boolean[N][M];
        blueVisited = new boolean[N][M];
        redVisited[redStart.x][redStart.y] = true;
        blueVisited[blueStart.x][blueStart.y] = true;
        
        dfs(0, redStart, blueStart);
        
        redVisited = new boolean[N][M];
        blueVisited = new boolean[N][M];
        redVisited[blueStart.x][blueStart.y] = true;
        blueVisited[redStart.x][redStart.y] = true;
        Node temp = redTarget;
        redTarget = blueTarget;
        blueTarget = temp;
        
        dfs(0, blueStart, redStart);
        
        return answer == Integer.MAX_VALUE ? 0 : answer;
    }
    
    void dfs(int depth, Node red, Node blue) {
        // 수레가 모두 도착 칸인 경우
        if (redIsTarget(red) && blueIsTarget(blue)) {
            answer = Math.min(answer, depth);
            return;
        }
        
        for (int i = 0; i < 4; i++) {
            int rx = red.x + dx[i];
            int ry = red.y + dy[i];
            
             if (redIsTarget(red)) {
                rx = red.x;
                ry = red.y;
                redVisited[rx][ry] = false;
            }
            
            if (rx < 0 || rx >= N || ry < 0 || ry >= M) continue;
            if (map[rx][ry] == -1 || redVisited[rx][ry] || (rx == blue.x && ry == blue.y)) continue;
            
            for (int j = 0; j < 4; j++) {
                int bx = blue.x + dx[j];
                int by = blue.y + dy[j];
                
                if (blueIsTarget(blue)) {
                    bx = blue.x;
                    by = blue.y;
                    blueVisited[bx][by] = false;
                }

                if (bx < 0 || bx >= N || by < 0 || by >= M) continue;
                if (map[bx][by] == -1 || blueVisited[bx][by] || (bx == rx && by == ry)) continue;
                
                redVisited[rx][ry] = true;
                blueVisited[bx][by] = true;
                
                dfs(depth + 1, new Node(rx, ry), new Node(bx, by));
                
                redVisited[rx][ry] = false;
                blueVisited[bx][by] = false;
            }
        }
    }
    
    boolean redIsTarget(Node red) {
        return red.x == redTarget.x && red.y == redTarget.y;
    }
    
    boolean blueIsTarget(Node blue) {
        return blue.x == blueTarget.x && blue.y == blueTarget.y;
    }
}

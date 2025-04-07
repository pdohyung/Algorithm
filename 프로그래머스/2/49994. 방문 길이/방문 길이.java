import java.util.*;

class Solution {
    public int solution(String dirs) {
        int[] dx = {0, -1, 0, 1};
        int[] dy = {-1, 0, 1, 0};
        int x = 5;
        int y = 5;
        int answer = 0;
        boolean[][][] visited = new boolean[11][11][4];
        
        Queue<Integer> q = new ArrayDeque<>();
        
        for (char d : dirs.toCharArray()) {
            if (d == 'L') q.add(0);
            else if (d == 'U') q.add(1);
            else if (d == 'R') q.add(2);
            else if (d == 'D') q.add(3);
        }
        
        while (!q.isEmpty()) {
            int now = q.poll();
            int nx = x + dx[now];
            int ny = y + dy[now];
            
            if (nx < 0 || nx > 10 || ny < 0 || ny > 10) continue;
            
            if (!visited[nx][ny][now]) {
                answer++;
                visited[nx][ny][now] = true;
                visited[x][y][(now + 2) % 4] = true;
            }
            
            x = nx;
            y = ny;
        }
        
        return answer;
    }
}

import java.util.*;

class Solution {
    
    int M, N;
    char[][] map;
    boolean[][] visited;
    
    public int solution(int m, int n, String[] board) {
        M = m;
        N = n;
        
        map = new char[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = board[i].charAt(j);
            }
        }
        
        int answer = 0;
        
        while (true) {
            int cnt = 0;
            visited = new boolean[M][N];
            
            // 블록 지우기
            for (int i = 0; i < M - 1; i++) {
                for (int j = 0; j < N - 1; j++) {
                    char c = map[i][j];
                    if (c == 'X') continue;
                    
                    if (map[i][j + 1] == c && map[i + 1][j] == c && map[i + 1][j + 1] == c) {
                        visited[i][j] = true;
                        visited[i][j + 1] = true;
                        visited[i + 1][j] = true;
                        visited[i + 1][j + 1] = true;
                    }
                }
            }

            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    if (visited[i][j]) {
                        map[i][j] = 'X';
                        cnt++;
                    }
                }
            }
            
            // 블록 떨어뜨리기
            for (int j = 0; j < N; j++) {
                int emptyRow = M - 1;
                for (int i = M - 1; i >= 0; i--) {
                    if (map[i][j] == 'X') continue;
                    map[emptyRow][j] = map[i][j];
                    if (emptyRow != i) map[i][j] = 'X';
                    emptyRow--;
                }
            }

            if (cnt == 0) break;
            answer += cnt;
        }
        
        return answer;
    }
}

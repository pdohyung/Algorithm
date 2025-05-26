import java.util.*;

class Solution {
    
    int[][] K, L;
    int M, N, C;
    
    public boolean solution(int[][] key, int[][] lock) {
        // 자물쇠는 N x N 크기의 정사각 격자 형태, 열쇠는 M x M 크기의 정사각
        // 열쇠의 돌기 부분을 자물쇠 홈 부분에 딱 맞게 채우면 자물쇠가 열림
        // 자물쇠 영역을 벗어난 키의 모양은 영향을 주지 않지만, 자물쇠 영역 내에서는 자물쇠의 홈과 정확히 일치해야함
        K = key;
        L = lock;
        M = key.length;
        N = lock.length;
        C = 0;
        
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                if (L[x][y] == 0) C++;
            }
        }
        
        // 방향 회전
        for (int d = 0; d < 4; d++) {
            int[][] T = new int[M][M];
            T = K;
            K = new int[M][M];
            
            // 시계 방향으로 90도 회전
            for (int x = 0; x < M; x++) {
                for (int y = 0; y < M; y++) {
                    K[y][M - x - 1] = T[x][y];
                }
            }
            
            for (int dx = -M + 1; dx < N; dx++) {
                for (int dy = -M + 1; dy < N; dy++) {
                    if (check(dx, dy)) {
                        return true;
                    }
                }
            }
            
        }
        
        return false;
    }
    
    boolean check(int dx, int dy) {
        int cnt = 0;
        
        for (int x = 0; x < M; x++) {
            for (int y = 0; y < M; y++) {
                int nx = x + dx;
                int ny = y + dy;
                
                if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                
                int k = K[x][y];
                int l = L[nx][ny];
                
                if (k == l) return false;
                if (k == 1 && l == 0) cnt++;
            }
        }
        
        return cnt < C ? false : true;
    }
}

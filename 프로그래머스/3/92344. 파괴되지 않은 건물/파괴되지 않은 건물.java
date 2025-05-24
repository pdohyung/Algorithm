import java.util.*;

class Solution {
    public int solution(int[][] board, int[][] skill) {
        // 내구도를 가진 건물이 칸마다 하나씩 존재, 적은 건물을 공격하고, 내구도가 0이 되면 파괴
        // 아군은 회복 스킬을 사용해 건물의 내구도를 올림, 최종에 내구도가 1이상인 건물의 개수를 리턴
        int N = board.length;
        int M = board[0].length;
        int[][] S = new int[N + 1][M + 1];
        
        for (int[] s : skill) {
            int type = s[0];
            int d = type == 1 ? -s[5] : s[5];
            int r1 = s[1] + 1;
            int c1 = s[2] + 1;
            int r2 = s[3] + 1;
            int c2 = s[4] + 1;
            
            S[r1][c1] += d;
            if (r2 < N) S[r2 + 1][c1] -= d;
            if (c2 < M) S[r1][c2 + 1] -= d;
            if (r2 < N && c2 < M) S[r2 + 1][c2 + 1] += d;
        }
        
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                S[i][j] += S[i][j - 1];
            }
        }
        
        for (int j = 1; j <= M; j++) {
            for (int i = 1; i <= N; i++) {
                S[i][j] += S[i - 1][j];
            }
        }
        
        int answer = 0;
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                board[i][j] += S[i + 1][j + 1];
                if (board[i][j] > 0) answer++;
            }
        }
        
        return answer;
    }
}

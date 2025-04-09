class Solution {
    public int solution(int[][] board) {
        int w = board[0].length;
        int h = board.length;
        int[][] map = new int[h + 1][w + 1];
        int len = 0;
        
        for (int i = 1; i <= h; i++) {
            for (int j = 1; j <= w; j++) {
                if (board[i - 1][j - 1] == 0) continue;
                
                map[i][j] = Math.min(Math.min(map[i][j - 1], map[i - 1][j]), map[i - 1][j - 1]) + 1;
                len = Math.max(len, map[i][j]);
            }
        }

        return len * len;
    }
}

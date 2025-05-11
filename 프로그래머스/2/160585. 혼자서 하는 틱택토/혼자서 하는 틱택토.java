class Solution {
    
    public int solution(String[] board) {
        // 빈칸 = 1, O보다 X 개수가 많으면 = 0
        // O와 X 개수가 같거나 O가 1개 더 많아야 함
        // 빙고가 2개 이상 = 0
        char[][] B = new char[3][3];
        
        int O = 0;
        int X = 0;
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                char c = board[i].charAt(j);
                B[i][j] = c;
                
                if (c == 'O') O++;
                else if (c == 'X') X++;
            }
        }
        
        if (O == 0 && X == 0) return 1;
        
        int bO = getCount(B, 'O');
        int bX = getCount(B, 'X');
        
        if (bO > 0 && bX > 0) return 0;
        else if (bO == 3 || bX == 3) return 0;
        
        if (O - X == 1) {
            if (bX > bO) return 0;
        } else if (O == X) {
            if (bO > bX) return 0;
        } else {
            return 0;
        }
        
        return 1;
    }
    
    int getCount(char[][] B, char target) {
        int cnt = 0;
        
        for (int i = 0; i < 3; i++) {
            if (B[i][0] == target && B[i][0] == B[i][1] && B[i][1] == B[i][2]) cnt++;
            if (B[0][i] == target && B[0][i] == B[1][i] && B[1][i] == B[2][i]) cnt++;
        }
        
        if (B[0][0] == target && B[0][0] == B[1][1] && B[1][1] == B[2][2]) cnt++;
        if (B[0][2] == target && B[0][2] == B[1][1] && B[1][1] == B[2][0]) cnt++;
            
        return cnt;
    }
}

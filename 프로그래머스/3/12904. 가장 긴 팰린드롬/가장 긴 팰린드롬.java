class Solution {
    public int solution(String s) {
        int len = s.length();
        boolean[][] dp = new boolean[len + 1][len + 1];
        char[] A = new char[len + 1];
        
        A[0] = '.';
        for (int i = 1; i <= len; i++) {
            A[i] = s.charAt(i - 1);
        }
        
        for (int i = 1; i <= len; i++) {
            int l = i;
            int r = i;
            
            while (l > 0 && r <= len && A[l] == A[r]) {
                dp[l--][r++] = true;
            }
            
            l = i;
            r = i + 1;
            
            while (l > 0 && r <= len && A[l] == A[r]) {
                dp[l--][r++] = true;
            }
        }
        
        int answer = 0;
        
        for (int i = 1; i <= len; i++) {
            for (int j = i; j <= len; j++) {
                if (dp[i][j]) {
                    // System.out.println(i + " " + j + " " + dp[i][j]);
                    answer = Math.max(answer, j - i + 1);
                }
            }
        }

        return answer;
    }
}

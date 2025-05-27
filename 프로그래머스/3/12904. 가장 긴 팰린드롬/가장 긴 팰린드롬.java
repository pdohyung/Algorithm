class Solution {
    public int solution(String s) {
        // dp[i][j], 인덱스 i부터 j까지의 수가 팰린드롬인지 여부
        // 가장 긴 길이를 리턴
        int N = s.length();
        char[] A = s.toCharArray();
        boolean[][] dp = new boolean[N][N];
        
        for (int i = 0; i < N; i++) {
            int left = i;
            int right = i;
            
            while (left >= 0 && right < N && A[left] == A[right]) {
                dp[left--][right++] = true;
            }
            
            left = i;
            right = i + 1;
            
            while (left >= 0 && right < N && A[left] == A[right]) {
                dp[left--][right++] = true;
            }
        }
        
        int answer = 0;
        
        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                if (dp[i][j]) {
                    answer = Math.max(answer, j - i + 1);
                }
            }
        }

        return answer;
    }
}

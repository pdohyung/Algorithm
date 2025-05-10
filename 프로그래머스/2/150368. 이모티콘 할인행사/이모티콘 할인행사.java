import java.util.*;

class Solution {
    
    int[] E, now, discount, answer;
    int[][] U;
    int N;
    
    public int[] solution(int[][] users, int[] emoticons) {
        E = emoticons;
        U = users;
        N = emoticons.length;
        discount = new int[4];
        for (int i = 0; i < 4; i++) discount[i] = (i + 1) * 10;
        
        answer = new int[2];
        dfs(0, new int[N]);
        return answer;
    }
    
    void dfs(int depth, int[] now) {
        if (depth == N) {
            int[] result = cal(now);
            
            if (result[0] > answer[0]) {
                answer = result;
            } else if (result[0] == answer[0]) {
                answer[1] = Math.max(result[1], answer[1]);
            }
            
            return;
        }
        
        for (int d = 0; d < 4; d++) {
            now[depth] = discount[d];
            dfs(depth + 1, now);
        }
    }
    
    int[] cal(int[] now) {
        int cnt = 0;
        int total = 0;
        
        for (int u = 0; u < U.length; u++) {
            int sum = 0;
            int[] user = U[u];
            
            for (int n = 0; n < N; n++) {
                if (now[n] >= user[0]) {
                    sum += E[n] * (100 - now[n]) / 100;
                }
            }
            
            if (sum >= user[1]) {
                cnt++;
            } else {
                total += sum;
            }
        }
        
        return new int[] {cnt, total};
    }
}

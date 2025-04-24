import java.util.*;

class Solution {
    
    int[] num, cnt;
    int N;
    
    public int solution(int[] numbers, int target) {
        num = numbers;
        N = numbers.length;
        cnt = new int[1_001];

        dfs(0, 0);

        return cnt[target];
    }
    
    void dfs(int depth, int now) {
        if (depth == N) {
            if (now > 0) cnt[now]++;
            return;
        }
        
        int plus = now + num[depth];
        int minus = now - num[depth];
        
        dfs(depth + 1, plus);
        dfs(depth + 1, minus);
    }
}

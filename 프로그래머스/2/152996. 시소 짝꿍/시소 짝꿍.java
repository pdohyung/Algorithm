import java.util.*;

class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        long[] a = new long[4_001];
        
        for (int i = 0; i < weights.length; i++) a[weights[i]]++;
        
        for (int i = 0; i < a.length; i++) {
            long now = a[i];
            if (now > 1) answer += now * (now - 1) / 2;
        }
        
        for (int i = 0; i < weights.length; i++) {
            int now = weights[i];
            if (now * 4 % 3 == 0) answer += a[now * 4 / 3];
            if (now * 4 % 2 == 0) answer += a[now * 4 / 2];
            if (now * 3 % 2 == 0) answer += a[now * 3 / 2];
        }
        
        return answer;
    }
}

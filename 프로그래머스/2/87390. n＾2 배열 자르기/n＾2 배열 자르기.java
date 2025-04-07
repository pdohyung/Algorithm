import java.util.*;

class Solution {
    
    public int[] solution(int n, long left, long right) {
        int len = (int) right - (int) left + 1;
        int[] answer = new int[len];
        
        int cnt = 0;
        for (long i = left; i <= right; i++) {
            long col = i / n;
            long row = i % n;
            answer[cnt++] = Math.max((int) col, (int) row) + 1;
        }
        
        return answer;
    }
}

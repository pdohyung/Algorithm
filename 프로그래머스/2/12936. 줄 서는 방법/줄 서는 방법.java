import java.util.*;

class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        ArrayList<Integer> list = new ArrayList<>();
        long total = 1;
        
        for (int i = 1; i <= n; i++) {
            list.add(i);
            total *= i;
        }
        
        // idx는 0부터 시작이므로 찾는 수 -1
        k--;
        
        int idx = 0;
        while (idx < n) {
            total /= n - idx;
            answer[idx++] = list.remove((int) (k / total));
            k %= total;
        }
        
        return answer;
    }
}

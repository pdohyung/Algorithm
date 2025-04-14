import java.util.*;

class Solution {
    public int solution(int[] order) {
        Stack<Integer> sub = new Stack<>();
        int n = order.length;
        int box = 1;
        int idx = 0;
        int answer = 0;
        
        while (box <= n) {
            if (order[idx] == box) {
                answer++;
                box++;
                idx++;
            } else if (!sub.isEmpty() && sub.peek() == order[idx]) {
                sub.pop();
                answer++;
                idx++;
            } else {
                sub.push(box);
                box++;
            }
        }
        
        while (idx < n && !sub.isEmpty() && order[idx] == sub.peek()) {
            sub.pop();
            idx++;
            answer++;
        }
        
        return answer;
    }
}

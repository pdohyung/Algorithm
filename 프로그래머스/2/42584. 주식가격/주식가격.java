import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int len = prices.length;
        int[] answer = new int[len];
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
                int before = stack.pop();
                answer[before] = i - before;
            }
            
            stack.push(i);
        }
        
        while (!stack.isEmpty()) {
            int before = stack.pop();
            answer[before] = len - 1 - before;
        }
        
        return answer;
    }
}

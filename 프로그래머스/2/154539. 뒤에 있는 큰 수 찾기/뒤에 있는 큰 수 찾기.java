import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int[] numbers) {
        
        int N = numbers.length;
        int[] answer = new int[N];
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        
        stack.push(0);
        
        // 전체 반복
        for(int i = 1; i < N; i++) {
            // stack에 값이 있고, 현재 비교하는 값이 크다면 정답 배열에 추가
            while (!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) {
                answer[stack.pop()] = numbers[i];
            }
            // 현재 반복 숫자 삽입
            stack.push(i);
        }
        
        // 끝까지 남은 숫자는 뒷큰수가 없으므로 -1
        while (!stack.isEmpty()) {
            answer[stack.pop()] = -1;
        }
        
        return answer;
    }
}
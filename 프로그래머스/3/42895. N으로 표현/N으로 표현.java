import java.util.*;

class Solution {
    public int solution(int N, int number) {
        // 사칙 연산으로 number을 표현할 때, 최소 사용횟수 리턴
        int answer = -1;
        Set<Integer>[] result = new HashSet[9];
        for (int i = 1; i <= 8; i++) result[i] = new HashSet<>();
        
        String now = "";
        
        for (int i = 1; i <= 8; i++) {
            now += N;
            result[i].add(Integer.parseInt(now));
        }
        
        for (int i = 2; i <= 8; i++) {
            for (int j = 1; j < i; j++) {
                Set<Integer> A = result[j];
                Set<Integer> B = result[i - j];
                
                for (int a : A) {
                    for (int b : B) {
                        result[i].add(a + b);
                        result[i].add(a - b);
                        result[i].add(a * b);
                        if (b != 0) result[i].add(a / b);
                    }
                }
            }
        }
        
        for (int i = 1; i <= 8; i++) {
            if (result[i].contains(number)) {
                answer = i;
                break;
            }
        }
        
        return answer;
    }
}

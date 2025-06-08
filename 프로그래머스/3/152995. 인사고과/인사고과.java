import java.util.*;

class Score {
    int a, b;
    
    Score(int a, int b) {
        this.a = a;
        this.b = b;
    }
}

class Solution {
    public int solution(int[][] scores) {
        // 각 사원은 근태, 동료 점수가 있음, 임의의 사원보다 두 점수가 모두 낮은 경우라면 인센티브를 못받음
        // 그렇지 않은 사원들에 대해서 두 점수의 합이 높은 순서대로 석차를 내며 차등 지급
        // 합이 동일하면 동석차, 동석차의 수만큼 다음 석차는 건너뜀
        int ta = scores[0][0];
        int tb = scores[0][1];
        PriorityQueue<Score> pq = new PriorityQueue<>((a, b) -> {
           if (a.a != b.a) return b.a - a.a;
            return a.b - b.b;
        });
        
        for (int[] score : scores) {
            pq.offer(new Score(score[0], score[1]));
        }
        
        List<Score> result = new ArrayList<>();
        int maxB = 0;
        
        while (!pq.isEmpty()) {
            Score now = pq.poll();
            int a = now.a;
            int b = now.b;
            
            if (b >= maxB) {
                maxB = b;
                result.add(now);
            }
        }
        
        result.sort((a, b) -> (b.a + b.b) - (a.a + a.b));
        
        int answer = -1;
        int rank = 0;
        int sum = Integer.MAX_VALUE;
        
        for (int i = 0; i < result.size(); i++) {
            Score now = result.get(i);
            int a = now.a;
            int b = now.b;
            
            if (a + b < sum) {
                sum = a + b;
                rank = i + 1;
            }
            
            if (a == ta && b == tb) {
                answer = rank;
                break;
            }
        }
        
        return answer;
    }
}

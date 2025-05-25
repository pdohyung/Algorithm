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
        // 각 사원마다 태도 점수, 동료 평가 점수 기록
        // 어떤 사원이 다른 임의의 사원보다 두 점수가 모두 낮은 경우가 한 번이라도 있다면, 인센티브 X
        // 그렇지 않은 사원에 대해서는 점수 합 내림차순으로 석차를 매김, 동석차 수만큼 다음 석차는 건너 띔
        // 완호의 점수는 0번째 배열이고, 못받는 경우는 -1을 리턴
        int targetA = scores[0][0];
        int targetB = scores[0][1];
        
        PriorityQueue<Score> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1.a != o2.a) return o2.a - o1.a;
            return o1.b - o2.b;
        });
        
        for (int[] s : scores) {
            pq.offer(new Score(s[0], s[1]));
        }
        
        List<Score> result = new ArrayList<>();
        
        int maxB = 0;
        
        while (!pq.isEmpty()) {
            Score now = pq.poll();
            int a = now.a;
            int b = now.b;
            
            if (a > targetA && b > targetB) return -1;
            
            if (b >= maxB) {
                result.add(now);
                maxB = b;
            }
        }
        
        Collections.sort(result, (o1, o2) -> (o2.a + o2.b) - (o1.a + o1.b));
        
        int answer = -1;
        int rank = 0;
        int sum = Integer.MAX_VALUE;
        
        for (int i = 0; i < result.size(); i++) {
            Score now = result.get(i);
            
            if (now.a + now.b < sum) {
                rank = i + 1;
                sum = now.a + now.b;
            }
            
            if (targetA == now.a && targetB == now.b) {
                answer = rank;
                break;
            }
        }
        
        return answer;
    }
}

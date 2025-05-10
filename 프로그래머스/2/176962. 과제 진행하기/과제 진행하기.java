import java.util.*;

class Plan {
    int start, cost;
    String name;
    
    Plan (int start, int cost, String name) {
        this.start = start;
        this.cost = cost;
        this.name = name;
    }
}

class Solution {
    public String[] solution(String[][] plans) {
        // 과제를 시작하는 시간이 되면 과제 시작
        // 기존에 진행 중이던 과제가 있으면 멈추고, 새로운 과제 시작
        // 과제 끝낸 시각에 새로 시작하는 과제가 있다면 바로 시작
        // 멈춘 과제가 여러 개라면, 가장 최근에 멈춘 과제부터 시작 (스택)
        PriorityQueue<Plan> pq = new PriorityQueue<>(Comparator.comparing(p -> p.start));
        for (String[] plan : plans) {
            String[] time = plan[1].split(":");
            int start = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
            int cost = Integer.parseInt(plan[2]);
            String name = plan[0];
            pq.offer(new Plan(start, cost, name));
        }
        
        List<String> result = new ArrayList<>();
        Stack<Plan> stack = new Stack<>();
        
        while (!pq.isEmpty()) {
            Plan now = pq.poll();
            int start = now.start;
            int cost = now.cost;
            String name = now.name;
            
            if (!pq.isEmpty() && pq.peek().start < start + cost) {
                now.cost = cost - (pq.peek().start - start);
                stack.push(now);
            } else if (!pq.isEmpty()) {
                result.add(name);
                int r = pq.peek().start - (start + cost);
                
                while (!stack.isEmpty() && r > 0) {
                    if (stack.peek().cost <= r) {
                        Plan s = stack.pop();
                        r -= s.cost;
                        result.add(s.name);
                    } else {
                        stack.peek().cost -= r;
                        r = 0;
                    }
                }
            } else {
                result.add(name);
            }
        }
        
        while (!stack.isEmpty()) {
            result.add(stack.pop().name);
        }
        
        String[] answer = new String[result.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }
}

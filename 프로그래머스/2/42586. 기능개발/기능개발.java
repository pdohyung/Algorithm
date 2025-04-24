import java.util.*;

class Node {
    int p, s;
    
    Node (int p, int s) {
        this.p = p;
        this.s = s;
    }
}

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int len = progresses.length;
        Queue<Node> q = new ArrayDeque<>();
        
        for (int i = 0; i < len; i++) {
            q.offer(new Node(progresses[i], speeds[i]));
        }
        
        List<Integer> result = new ArrayList<>();
        
        while(!q.isEmpty()) {
            Node f = q.peek();
            int cnt = (100 - f.p) / f.s;
            if ((100 - f.p) % f.s != 0) cnt++;
            
            for (Node n : q) {
                if (n.p >= 100) continue;
                n.p = n.p + n.s * cnt;
            }
            
            cnt = 0;
            
            for (Node n : q) {
                if (n.p >= 100) {
                    cnt++;
                } else break;
            }
            
            int end = 0;
            
            for (int i = 0; i < cnt; i++) {
                q.poll();
                end++;
            }
            
            result.add(end);
        }
        
        int[] answer = new int[result.size()];
        for(int i = 0; i < answer.length; i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }
}

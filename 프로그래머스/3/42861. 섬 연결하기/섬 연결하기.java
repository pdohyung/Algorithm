import java.util.*;

class Node {
    int end, cost;
    
    Node (int end, int cost) {
        this.end = end;
        this.cost = cost;
    }
}

class Solution {
    public int solution(int n, int[][] costs) {
        ArrayList<Node>[] graph = new ArrayList[n];
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();
        
        for (int[] cost : costs) {
            int start = cost[0];
            int end = cost[1];
            int c = cost[2];
            graph[start].add(new Node(end, c));
            graph[end].add(new Node(start, c));
        }
        
        int answer = 0;
        
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
        pq.add(new Node(0, 0));
        
        while (!pq.isEmpty()) {
            Node now = pq.poll();
            int end = now.end;
            int cost = now.cost;
            
            if (visited[end]) continue;
            visited[end] = true;
            answer += cost;
            
            for (Node next : graph[end]) {
                if (visited[next.end]) continue;
                pq.add(new Node(next.end, next.cost));
            }
        }
        
        return answer;
    }
}

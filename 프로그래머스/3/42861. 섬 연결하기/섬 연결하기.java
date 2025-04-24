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
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();
        
        for (int[] c : costs) {
            int start = c[0];
            int end = c[1];
            int cost = c[2];
            
            graph[start].add(new Node(end, cost));
            graph[end].add(new Node(start, cost));
        }
        
        // 각 노드와 연결된 최단 간선 찾기
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.cost, b.cost));
        pq.offer(new Node(0, 0));
        
        boolean[] visited = new boolean[n];
        int answer = 0;
        
        while(!pq.isEmpty()) {
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

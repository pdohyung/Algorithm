import java.util.*;

class Solution {
    
    public int N;
    public int[][] matrix;
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        
        N = n;
        matrix = new int[N + 1][N + 1];
        
        // 그래프 배열 표현
        for(int[] fare : fares) {
            int start = fare[0];
            int end = fare[1];
            matrix[start][end] = fare[2];
            matrix[end][start] = fare[2];
        }
        
        int minCost = Integer.MAX_VALUE;
        int[] together = dijkstra(s);
        
        for(int i = 1; i <= N; i++) {
            int[] alone = dijkstra(i);
            minCost = Math.min(minCost, together[i] + alone[a] + alone[b]);
        }
        
        return minCost;
    }
    
    public int[] dijkstra(int start) {
        // 첫번째 원소를 기준으로 우선순위 큐 생성
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        boolean[] visited = new boolean[N + 1];
        int[] dist = new int[N + 1];
        
        // 초기화
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        pq.add(new Node(0, start));
        
        while(!pq.isEmpty()) {
            Node now = pq.poll();
            int u = now.idx;
            
            if (visited[u]) {
                continue;
            }
            
            visited[u] = true;
            
            // 최단 경로 계산
            for(int v = 1; v <= N; v++) {
                // 본인 경로 제외
                if(matrix[u][v] == 0) {
                    continue;
                }
                
                if(dist[u] + matrix[u][v] < dist[v]) {
                    dist[v] = dist[u] + matrix[u][v];
                    // 이후 우선순위를 위한 추가
                    pq.add(new Node(dist[v], v));
                }
            }
        }
        return dist;
    }
}

class Node {
    int cost;
    int idx;
    
    Node (int cost, int idx) {
        this.cost = cost;
        this.idx = idx;
    }
}
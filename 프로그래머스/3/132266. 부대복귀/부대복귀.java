import java.util.*;

class Node {
    int pos, cost;
    
    Node (int pos, int cost) {
        this.pos = pos;
        this.cost = cost;
    }
}

class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        // 부대원들의 각 지역은 유일한 번호로 구분, 지역끼리 통과하는데 걸리는 시간 1로 동일
        // 각 부대원은 지도 정보로 *최단시간으로 부대 복귀를 하고 싶음
        // 적군의 방해로, 임무 이후에 경로가 없어져 못오는 부대원도 있음
        // 여러 지점에서 하나의 도착지점으로 최단시간
        // dest에서 각 지점으로 가는 최단시간 구하기
        List<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();
        
        for (int[] road : roads) {
            int start = road[0];
            int end = road[1];
            graph[start].add(end);
            graph[end].add(start);
        }
        
        List<Integer> result = new ArrayList<>();
        int start = destination;
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.cost, b.cost));
        pq.add(new Node(start, 0));

        while(!pq.isEmpty()) {
            Node now = pq.poll();
            int pos = now.pos;
            int cost = now.cost;

            if (dist[pos] < cost) continue;

            for (int next : graph[pos]) {
                if (dist[next] > dist[pos] + 1) {
                    dist[next] = dist[pos] + 1;
                    pq.add(new Node(next, dist[next]));
                }
            }
        }
        
        for (int s : sources) result.add(dist[s]);
        int[] answer = new int[result.size()];
        
        for (int i = 0; i < answer.length; i++) {
            int now = result.get(i);
            if (now == Integer.MAX_VALUE) answer[i] = -1;
            else answer[i] = result.get(i);
        }
        
        return answer;
    }
}

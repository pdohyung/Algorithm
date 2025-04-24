import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        ArrayList<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();
        boolean[] visited = new boolean[n + 1];
        
        for (int i = 0; i < n; i++) {
            int[] nodes = computers[i];
            
            for (int j = 0; j < nodes.length; j++) {
                if (i == j) continue;
                if (nodes[j] == 1) graph[i + 1].add(j + 1);
            }
        }
        
        int answer = 0;
        
        for (int i = 1; i <= n; i++) {
            if (visited[i]) continue;
            
            answer++;
            visited[i] = true;
            Queue<Integer> q = new ArrayDeque<>();
            q.offer(i);
            
            while (!q.isEmpty()) {
                int now = q.poll();
                
                for (int next : graph[now]) {
                    if (!visited[next]) {
                        visited[next] = true;
                        q.offer(next);
                    }
                }
            }
        }
        
        return answer;
    }
}

import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        ArrayList<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && computers[i][j] == 1) {
                    graph[i].add(j);
                }
            }
        }
        
        int answer = 0;
        boolean[] visited = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            
            visited[i] = true;
            answer++;
            
            Queue<Integer> q = new LinkedList<>();
            q.offer(i);
            
            while (!q.isEmpty()) {
                int now = q.poll();
                
                for (int next : graph[now]) {
                    if (visited[next]) continue;
                    visited[next] = true;
                    q.offer(next);
                }
            }
        }
        
        return answer;
    }
}

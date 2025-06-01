import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        // n개의 송전탑이 하나의 트리 형태, 전선들 중 하나를 끊어서 네트워크를 2개로 분할
        // 이때 두 전력망이 갖게 되는 송전탐의 개수를 최대한 비슷하게 만들기, 송전탑 개수 차이를 리턴
        int answer = n;
        
        ArrayList<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();
        
        for (int[] w : wires) {
            int s = w[0];
            int e = w[1];
            graph[s].add(e);
            graph[e].add(s);
        }
        
        for (int[] w : wires) {
            boolean[] visited = new boolean[n + 1];
            visited[w[0]] = true;
            
            Queue<Integer> q = new LinkedList<>();
            q.offer(w[1]);
            visited[w[1]] = true;
            int cnt = 1;
            
            while(!q.isEmpty()) {
                int now = q.poll();
                
                for (int next : graph[now]) {
                    if (!visited[next]) {
                        visited[next] = true;
                        q.offer(next);
                        cnt++;
                    }
                }
            }
            
            answer = Math.min(answer, Math.abs((n - cnt) - cnt));
        }
        
        return answer;
    }
}

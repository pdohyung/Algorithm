import java.util.*;

class Solution {
    
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int result, min;
    
    public int solution(int n, int[][] wires) {
        graph = new ArrayList[n + 1];
        min = Integer.MAX_VALUE;
        
        // 그래프 초기화
        for(int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        // 송전탑 전선 추가
        for(int[] wire : wires) {
            graph[wire[0]].add(wire[1]);
            graph[wire[1]].add(wire[0]);
        }
        
        // 완전 탐색
        for(int[] wire : wires) {
            result = 0;
            visited = new boolean[n + 1];

            graph[wire[0]].remove(Integer.valueOf(wire[1]));
            graph[wire[1]].remove(Integer.valueOf(wire[0]));
            
            for(int i = 1; i <= n; i++) {
                dfs(i);
                if(result != 0) {
                    break;
                }
            }
            
            graph[wire[0]].add(wire[1]);
            graph[wire[1]].add(wire[0]);
            
            min = Math.min(min, Math.abs((n - result) - result));
        }
        return min;
    }
    
    public void dfs(int now) {
        
        for(int next : graph[now]) {
            if(!visited[next]){
                result++;
                visited[next] = true;
                dfs(next);
            }
        }
    }
}

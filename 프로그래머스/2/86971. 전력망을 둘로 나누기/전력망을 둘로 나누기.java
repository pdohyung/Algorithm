import java.util.*;

class Solution {
    
    // static ArrayList<Integer>[] graph;
    static boolean[][] graph;
    static boolean[] visited;
    static int result, min, N;
    
    public int solution(int n, int[][] wires) {
        // graph = new ArrayList[n + 1];
        N = n;
        graph = new boolean[N + 1][N + 1];
        min = Integer.MAX_VALUE;
        
//         // 그래프 초기화
//         for(int i = 1; i <= n; i++) {
//             graph[i] = new ArrayList<>();
//         }
        
//         // 송전탑 전선 추가
//         for(int[] wire : wires) {
//             graph[wire[0]].add(wire[1]);
//             graph[wire[1]].add(wire[0]);
//         }
        
        // 송전탑 전선 추가
        for(int[] wire : wires) {
            graph[wire[0]][wire[1]] = true;
            graph[wire[1]][wire[0]] = true;
        }
        
        // 완전 탐색
        for(int[] wire : wires) {
            result = 0;
            visited = new boolean[n + 1];
            
            graph[wire[0]][wire[1]] = false;
            graph[wire[1]][wire[0]] = false;
            
            for(int i = 1; i <= n; i++) {
                dfs(i);
                if(result != 0) {
                    break;
                }
            }
            
            graph[wire[0]][wire[1]] = true;
            graph[wire[1]][wire[0]] = true;
            // System.out.println(result);
            // System.out.println(min + " " + Math.abs(n-result));
            min = Math.min(min, Math.abs((N - result) - result));
        }
        
        return min;
    }
    
    public void dfs(int now) {
        for(int next = 1; next <= N; next++) {
            if(!visited[next] && graph[now][next]){
                result++;
                visited[next] = true;
                dfs(next);
            }
        }
    }
}

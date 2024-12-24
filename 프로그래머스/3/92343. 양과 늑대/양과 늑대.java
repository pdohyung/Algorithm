import java.util.*;

class Solution {
    
    public int[] infoz;
    public int[][] edgesz;
    public int answer;

    public int solution(int[] info, int[][] edges) {
        infoz = info;
        edgesz = edges;
        answer = 0;
        // 시작 방문 배열 설정
        boolean[] visited = new boolean[info.length];
        // dfs 수행
        dfs(visited, 0, 0, 0);
        
        return answer;
    }

    public void dfs(boolean[] visited, int current, int sheep, int wolf) {
        
        // 현재 방문 노드 체크
        visited[current] = true;
        int type = infoz[current];
        
        if (type == 0) {
            sheep++;
            // 양의 최댓값 갱신
            answer = Math.max(sheep, answer);
        } else if (type == 1) {
            wolf++;
            // 늑대의 수가 양의 수가 같아지면 반환
            if (wolf == sheep) {
                return;
            }
        }
        
        // 주어진 edges를 사용
        for(int[] edge : edgesz) {
            int start = edge[0];
            int end = edge[1];
            
            // 시작 노드 방문 && 도착 노드 방문하지 않은 경우
            if (visited[start] && !visited[end]) { 
                boolean[] nextVisited = new boolean[visited.length];
                for(int i = 0; i < visited.length; i++) {
                    nextVisited[i] = visited[i];
                }
                dfs(nextVisited, end, sheep, wolf);
            }
        }
    }
}
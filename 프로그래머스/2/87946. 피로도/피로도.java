class Solution {
    
    int[][] d;
    boolean[] visited;
    int len, answer;
    
    public int solution(int k, int[][] dungeons) {
        d = dungeons;
        len = dungeons.length;
        visited = new boolean[len];
        answer = 0;
        
        dfs(0, k);
        
        return answer;
    }
    
    void dfs(int depth, int k) {
        answer = Math.max(answer, depth);
        
        for (int i = 0; i < len; i++) {
            int[] now = d[i];
            
            if (!visited[i] && k >= now[0]) {
                visited[i] = true;
                dfs(depth + 1, k - now[1]);
                visited[i] = false;
            }
        }
    }
}

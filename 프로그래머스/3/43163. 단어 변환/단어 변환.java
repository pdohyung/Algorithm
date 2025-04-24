class Solution {
    
    boolean[] visited;
    String[] W;
    String T;
    int answer;
    
    public int solution(String begin, String target, String[] words) {
        W = words;
        T = target;
        boolean isContain = false;
        
        for (String w : W) {
            if (w.equals(target)) {
                isContain = true;
                break;
            }
        }
        
        if (!isContain) return 0;
        
        answer = Integer.MAX_VALUE;
        visited = new boolean[words.length];
        
        dfs(0, begin);
        
        if (answer == Integer.MAX_VALUE) return 0;
        else return answer;
    }
    
    void dfs(int depth, String now) {
        if (now.equals(T)) {
            answer = Math.min(answer, depth);
            return;
        }
        
        for (int i = 0; i < W.length; i++) {
            if (!visited[i] && check(now, W[i])) {
                visited[i] = true;
                dfs(depth + 1, W[i]);
                visited[i] = false;
            }
        }
    }
    
    boolean check(String now, String next) {
        int cnt = 0;
        
        for (int i = 0; i < now.length(); i++) {
            if (now.charAt(i) != next.charAt(i)) cnt++;
        }
        
        if (cnt <= 1) return true;
        else return false;
    }
}

class Solution {
    
    static String nbegin, ntarget;
    static String[] nwords;
    static boolean[] visited;
    static int min;
    
    public int solution(String begin, String target, String[] words) {
        // 데이터 정리
        nbegin = begin;
        ntarget = target;
        nwords = words;
        
        visited = new boolean[words.length];
        min = Integer.MAX_VALUE;
        
        // 백트래킹 수행
        dfs(0, begin);
        
        if(min == Integer.MAX_VALUE) return 0;
        return min;
    }
    
    public void dfs(int cnt, String now) {
        if(ntarget.equals(now)) {
            min = Math.min(min, cnt);
            return;
        }
        
        for(int i = 0; i < nwords.length; i++) {
            String next = nwords[i];
            if(!visited[i] && isValid(now, next)) {
                visited[i] = true;
                dfs(cnt + 1, next);
                visited[i] = false;
            }
        }
    }
    
    public boolean isValid(String s1, String s2) {
        int cnt = 0;
        for(int i = 0; i < s1.length(); i++) {
            if(s1.charAt(i) != s2.charAt(i)) cnt++;
        }
        
        if(cnt == 1) return true;
        return false;
    }
}

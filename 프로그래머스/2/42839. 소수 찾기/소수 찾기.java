import java.util.*;

class Solution {
    
    boolean[] isPrime, visited;
    int N;
    char[] A;
    Set<Integer> result;
    
    public int solution(String numbers) {
        int S = 10_000_001;
        isPrime = new boolean[S];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        
        for (int i = 2; i <= Math.sqrt(S); i++) {
            if (!isPrime[i]) continue;
            
            for (int j = i * i; j < S; j += i) {
                isPrime[j] = false;
            }
        }
        
        N = numbers.length();
        A = numbers.toCharArray();
        visited = new boolean[N];
        result = new HashSet<>();
        
        dfs(0, "");
        
        return result.size();
    }
    
    void dfs(int depth, String now) {
        if (depth == N) return;
        
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                int n = Integer.parseInt(now + A[i]);
                if (isPrime[n]) result.add(n);
                dfs(depth + 1, now + A[i]);
                visited[i] = false;
            }
        }
    }
}

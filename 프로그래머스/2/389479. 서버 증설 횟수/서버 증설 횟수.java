import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int n = players.length;
        Queue<Integer> server = new ArrayDeque<>();
        
        for (int i = 0; i < n; i++) {
            int need = players[i] / m;
            
            while (!server.isEmpty() && server.peek() == i) {
                server.poll();
            }
            
            int now = server.size();
            
            if (need > now) {
                int newServer = need - now;
                answer += newServer;
                
                for (int j = 0; j < newServer; j++) {
                    server.offer(i + k);
                }
            }
        }

        return answer;
    }
}

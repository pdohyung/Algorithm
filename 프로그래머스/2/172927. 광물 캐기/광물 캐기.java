import java.util.*;

class Solution {
    
    int N, answer;
    int[] P;
    String[] M;
    Map<String, Integer> map;
    int[][] cost;
    
    public int solution(int[] picks, String[] minerals) {
        // 각 곡괭이는 5번 캐면 사라짐
        // 캐는 순서에 따라 피로도가 다르므로, 최소한의 피로도를 구하기
        // 각 곡괭이를 뒤에서 쓰는게 더 피로도가 적을 수 있음
        P = picks;
        M = minerals;
        map = new HashMap<>();
        map.put("diamond", 0);
        map.put("iron", 1);
        map.put("stone", 2);
        
        cost = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i - j == 1) cost[i][j] = 5;
                else if (i - j == 2) cost[i][j] = 25;
                else cost[i][j] = 1;
            }
        }
        
        int t = picks[0] + picks[1] + picks[2];
        int m = minerals.length / 5;
        if (minerals.length % 5 != 0) m++;
        N = Math.min(t, m);
        
        answer = Integer.MAX_VALUE;
        dfs(0, 0);
        return answer;
    }
    
    void dfs(int depth, int sum) {
        if (depth == N) {
            answer = Math.min(answer, sum);
            return;
        }
        
        for (int i = 0; i < 3; i++) {
            if (P[i] != 0) {
                P[i]--;
                dfs(depth + 1, sum + cal(i, depth));
                P[i]++;
            }
        }
    }
    
    // 피로도 계산
    int cal(int p, int depth) {
        int result = 0;
        int max = Math.min ((depth + 1) * 5, M.length);
        
        for (int i = depth * 5; i < max; i++) {
            result += cost[p][map.get(M[i])];
        }
        
        return result;
    }
}

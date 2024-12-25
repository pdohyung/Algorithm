import java.util.*;

class Solution {
    public int[][] dp;
    public ArrayList<Integer>[] graph;
    public int[] sales;

    public int solution(int[] sales, int[][] links) {
        int n = sales.length;
        this.sales = sales;

        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] link : links) {
            int parent = link[0];
            int child = link[1];
            graph[parent].add(child);
        }

        dp = new int[n + 1][2];

        dfs(1);
        
        return Math.min(dp[1][0], dp[1][1]);
    }

    public void dfs(int node) {
        // 팀장이 참석하지 않는 경우, 참석하는 경우
        dp[node][0] = 0;
        dp[node][1] = sales[node - 1];
        
        if(graph[node].isEmpty()) {
            return;
        }
        
        // 참석하는 팀원의 최소 매출 값
        int extraCost = Integer.MAX_VALUE;
        
        for(int child : graph[node]) {
            dfs(child);
            
            dp[node][0] += Math.min(dp[child][0] , dp[child][1]);
            dp[node][1] += Math.min(dp[child][0] , dp[child][1]);
            
            extraCost = Math.min(extraCost, dp[child][1] - dp[child][0]);
        }
        
        // 팀장이 참석하지 않은 경우, 팀원(최소 매출)이 참석해야 함.
        dp[node][0] += (extraCost < 0 ? 0 : extraCost);
    }
}
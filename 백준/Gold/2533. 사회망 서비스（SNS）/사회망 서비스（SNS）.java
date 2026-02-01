import java.util.*;
import java.io.*;

public class Main {

    private static int[][] dp;
    private static List<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            graph[s].add(e);
            graph[e].add(s);
        }

        dp = new int[N + 1][2];
        dfs(1, 1);

        System.out.println(Math.min(dp[1][0], dp[1][1]));
    }

    private static void dfs(int now, int parent) {
        dp[now][0] = 0;
        dp[now][1] = 1; // 본인

        for (int next : graph[now]) {
            if (next == parent) continue;

            dfs(next, now);

            dp[now][0] += dp[next][1];
            dp[now][1] += Math.min(dp[next][0], dp[next][1]);
        }
    }
}

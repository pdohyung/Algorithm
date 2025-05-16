
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder answer = new StringBuilder();

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int[] cost = new int[N + 1];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                cost[i] = Integer.parseInt(st.nextToken());
            }

            ArrayList<Integer>[] graph = new ArrayList[N + 1];
            int[] d = new int[N + 1];

            for (int i = 1; i <= N; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                graph[s].add(e);
                d[e]++;
            }

            int W = Integer.parseInt(br.readLine());
            int[] dp = new int[N + 1];
            Queue<Integer> q = new LinkedList<>();

            for (int i = 1; i <= N; i++) {
                if (d[i] == 0) {
                    q.offer(i);
                    dp[i] = cost[i];
                }
            }

            while (!q.isEmpty()) {
                int now = q.poll();

                for (int next : graph[now]) {
                    dp[next] = Math.max(dp[next], dp[now] + cost[next]);

                    if (--d[next] == 0) {
                        q.offer(next);
                    }
                }
            }

            answer.append(dp[W]).append("\n");
        }

        System.out.println(answer);
    }
}

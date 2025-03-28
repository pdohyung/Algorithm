
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] dp = new int[N + 1];
        int[] degree = new int[N + 1];
        ArrayList<Integer>[] graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            graph[start].add(end);
            degree[end]++;
        }

        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            if (degree[i] == 0) {
                dp[i] = 1;
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int now = q.poll();

            for (int next : graph[now]) {
                degree[next]--;
                dp[next] = Math.max(dp[next], dp[now] + 1);
                if (degree[next] == 0) q.add(next);
            }
        }

        StringBuilder answer = new StringBuilder();
        for (int i = 1; i <= N; i++) answer.append(dp[i]).append(" ");
        System.out.println(answer);
    }
}

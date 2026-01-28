import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Integer>[] graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();
        int[] cost = new int[N + 1];
        int[] depth = new int[N + 1];
        int[] result = new int[N + 1];
        Queue<Integer> q = new ArrayDeque<>();

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            cost[i] = Integer.parseInt(st.nextToken());
            int next = Integer.parseInt(st.nextToken());

            while (next != -1) {
                graph[next].add(i);
                depth[i]++;
                next = Integer.parseInt(st.nextToken());
            }

            if (depth[i] == 0) {
                q.offer(i); // 초기 진입차수 0 삽입
            }
        }

        while (!q.isEmpty()) {
            int now = q.poll();
            result[now] += cost[now];

            for (int next : graph[now]) {
                result[next] = Math.max(result[next], result[now]);
                if (--depth[next] == 0) {
                    q.offer(next);
                }
            }
        }

        StringBuilder answer = new StringBuilder();
        for (int i = 1; i <= N; i++) answer.append(result[i]).append("\n");
        System.out.println(answer);
    }
}

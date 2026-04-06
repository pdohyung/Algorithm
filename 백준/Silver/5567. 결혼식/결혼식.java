import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        List<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            graph[s].add(e);
            graph[e].add(s);
        }

        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{1, 0});
        boolean[] visited = new boolean[n + 1];
        visited[1] = true;
        int cnt = 0;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int now = cur[0];
            int d = cur[1];

            if (d > 2) continue;
            else {
                if (now != 1) cnt++;
            }

            for (int next : graph[now]) {
                if (visited[next]) continue;
                visited[next] = true;
                q.offer(new int[]{next, d + 1});
            }
        }

        System.out.println(cnt);
    }
}

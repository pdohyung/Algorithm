import java.util.*;
import java.io.*;

public class Main {

    static int[] result;
    static boolean[] visited;
    static List<Integer>[] graph;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            graph[s].add(e);
            graph[e].add(s);
        }

        for (int i = 1; i <= N; i++) Collections.sort(graph[i]);

        result = new int[N + 1];
        visited = new boolean[N + 1];

        cnt = 1;
        visited[R] = true;
        result[R] = cnt++;
        dfs(R);

        for (int i = 1; i <= N; i++) {
            System.out.println(result[i]);
        }
    }

    static void dfs(int now) {
        for (int next : graph[now]) {
            if (!visited[next]) {
                visited[next] = true;
                result[next] = cnt++;
                dfs(next);
            }
        }
    }
}

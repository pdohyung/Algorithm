
import java.util.*;
import java.io.*;

public class Main {

    static boolean[] visited;
    static List<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N];
        for (int i = 0; i < N; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            graph[s].add(e);
            graph[e].add(s);
        }

        for (int i = 0; i < N; i++) {
            visited = new boolean[N];
            visited[i] = true;
            dfs(1, i);
        }

        System.out.println(0);
    }

    static void dfs(int depth, int now) {
        if (depth == 5) {
            System.out.println(1);
            System.exit(0);
            return;
        }

        for (int next : graph[now]) {
            if (!visited[next]) {
                visited[next] = true;
                dfs(depth + 1, next);
                visited[next] = false;
            }
        }
    }
}

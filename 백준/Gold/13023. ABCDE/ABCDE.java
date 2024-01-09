import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static List<Integer>[] graph;
    static boolean[] visited;
    static boolean arrive;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            graph[start].add(end);
            graph[end].add(start);
        }

        for (int i = 0; i < n; i++) {
            dfs(i, 1);

            if (arrive) {
                break;
            }
        }

        if (arrive) {
            System.out.println(1);
            return;
        }

        System.out.println(0);
    }

    private static void dfs(int node, int depth) {
        if (depth == 5 || arrive) {
            arrive = true;
            return;
        }
        visited[node] = true;

        for (int i : graph[node]) {
            if (!visited[i]) {
                dfs(i, depth + 1);
            }
        }
        visited[node] = false;
    }
}
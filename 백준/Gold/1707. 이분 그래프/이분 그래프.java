import java.io.*;
import java.util.*;

public class Main {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    static ArrayList<Integer>[] graph;
    static boolean[] visit;
    static int[] group;
    static boolean flag;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    void solution() throws IOException {
        int K = Integer.parseInt(br.readLine());

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            graph = new ArrayList[V + 1];
            visit = new boolean[V + 1];
            group = new int[V + 1];
            flag = false;

            for (int j = 1; j <= V; j++) {
                graph[j] = new ArrayList<>();
            }

            for (int j = 0; j < E; j++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());

                graph[start].add(end);
                graph[end].add(start);
            }

            for (int j = 1; j <= V; j++) {
                dfs(j);
            }

            if (flag) {
                System.out.println("NO");
                continue;
            }
            System.out.println("YES");
        }

    }

    private void dfs(int startV) {
        visit[startV] = true;

        for (int v : graph[startV]) {
            if (!visit[v]) {
                group[v] = (group[startV] + 1) % 2;
                dfs(v);
                continue;
            }

            if (group[startV] == group[v]) {
                flag = true;
                return;
            }
        }
    }

}
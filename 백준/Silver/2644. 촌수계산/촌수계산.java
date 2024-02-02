import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    static ArrayList<Integer>[] graph;
    static boolean[] visit;
    static int[] res;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    void solution() throws IOException {
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(br.readLine());
        graph = new ArrayList[N + 1];
        visit = new boolean[N + 1];
        res = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            graph[start].add(end);
            graph[end].add(start);
        }

        dfs(X, 1);

        if (res[Y] == 0) {
            System.out.println(-1);
            return;
        }
        System.out.println(res[Y]);
    }

    private void dfs(int node, int depth) {
        if (visit[node]) {
            return;
        }
        visit[node] = true;

        for (int n : graph[node]) {
            if (!visit[n]) {
                res[n] = depth;
                dfs(n, depth + 1);
            }
        }
    }
}
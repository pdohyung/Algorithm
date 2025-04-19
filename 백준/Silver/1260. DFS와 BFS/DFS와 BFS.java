import java.util.*;
import java.io.*;

public class Main {

    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static StringBuilder answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            graph[start].add(end);
            graph[end].add(start);
        }

        for (int i = 1; i <= N; i++) Collections.sort(graph[i]);

        answer = new StringBuilder();

        visited = new boolean[N + 1];
        dfs(V);

        answer.append("\n");

        visited = new boolean[N + 1];
        bfs(V);

        System.out.println(answer);
    }

    static void dfs(int now) {
        visited[now] = true;
        answer.append(now).append(" ");

        for (int next : graph[now]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }

    static void bfs(int start) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(start);
        visited[start] = true;
        answer.append(start).append(" ");

        while (!q.isEmpty()) {
            int now = q.poll();

            for (int next : graph[now]) {
                if (!visited[next]) {
                    visited[next] = true;
                    answer.append(next).append(" ");
                    q.add(next);
                }
            }
        }
    }
}

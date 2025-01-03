import java.io.*;
import java.util.*;

public class Main {

    static ArrayList<Integer>[] graph;
    static int N;
    static boolean[] visited;
    static int[] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        graph = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        answer = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            graph[start].add(end);
            graph[end].add(start);
        }

        // DFS 수행
        visited[1] = true;
        dfs(1);

        for (int i = 2; i <= N; i++) {
            System.out.println(answer[i]);
        }
    }

    private static void dfs(int start) {
        for (int now : graph[start]) {
            if (!visited[now]) {
                visited[now] = true;
                answer[now] = start;
                dfs(now);
            }
        }
    }
}

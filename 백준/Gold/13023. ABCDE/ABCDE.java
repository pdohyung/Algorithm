import java.util.*;
import java.io.*;

public class Main {

    static int N, M, answer;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N];
        for (int i = 0; i < N; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            graph[start].add(end);
            graph[end].add(start);
        }

        answer = 0;

        for (int i = 0; i < N; i++) {
            visited = new boolean[N];
            dfs(i, 0);
            if (answer == 1) break;
        }

        System.out.println(answer);
    }

    private static void dfs(int start, int depth) {
        if (depth == 4) {
            answer = 1;
            return;
        }

        visited[start] = true;

        for (int next : graph[start]) {
            if (!visited[next]) {
                dfs(next, depth + 1);
                if (answer == 1) break;
            }
        }

        visited[start] = false;
    }
}

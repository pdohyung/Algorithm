import java.util.*;
import java.io.*;

public class Main {

    static int N, M, max;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        result = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            graph[end].add(start);
        }

        max = Integer.MIN_VALUE;

        for (int i = 1; i <= N; i++) {
            visited = new boolean[N + 1];
            result[i] = bfs(i);
            max = Math.max(max, result[i]);
        }

        StringBuilder answer = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if (result[i] == max) {
                answer.append(i).append(" ");
            }
        }

//        System.out.println(Arrays.toString(result));
        System.out.println(answer);
    }

    private static int bfs(int now) {
        visited = new boolean[N + 1];
        visited[now] = true;
        int cnt = 1;

        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.add(now);

        while (!q.isEmpty()) {
            int current = q.poll();

            for (int next : graph[current]) {

                if (visited[next]) continue;

                cnt++;
                visited[next] = true;
                q.add(next);
            }
        }

        return cnt;
    }
}

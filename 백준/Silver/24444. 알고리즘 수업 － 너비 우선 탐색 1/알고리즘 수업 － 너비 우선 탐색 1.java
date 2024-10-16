import java.io.*;
import java.util.*;

public class Main {

    static boolean[] visit;
    static List<Integer>[] graph;
    static List<Integer> result;
    static int[] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int startNode = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        visit = new boolean[N + 1];
        result = new ArrayList<Integer>();
        answer = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            graph[s].add(e);
            graph[e].add(s);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
        }

        bfs(startNode);

        for (int i = 0; i < result.size(); i++) {
            answer[result.get(i)] = i + 1;
        }

        for (int i = 1; i <= N; i++) {
            System.out.println(answer[i]);
        }
    }

    private static void bfs(int start) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        visit[start] = true;
        queue.add(start);

        while (!queue.isEmpty()) {
            int now = queue.poll();
            result.add(now);

            for (int next : graph[now]) {
                if (!visit[next]) {
                    visit[next] = true;
                    queue.add(next);
                }
            }
        }
    }
}

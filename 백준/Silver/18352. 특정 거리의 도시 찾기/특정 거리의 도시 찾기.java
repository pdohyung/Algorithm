import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    static int[] visit;
    static ArrayList<Integer>[] graph;
    static List<Integer> ans;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    void solution() throws IOException {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        visit = new int[N + 1];
        graph = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        ans = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            visit[i] = -1;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            graph[start].add(end);
        }

        bfs(X);

        for (int i = 1; i <= N; i++) {
            if (visit[i] == K) {
                ans.add(i);
            }
        }

        if (ans.isEmpty()) {
            System.out.println(-1);
            return;
        }

        Collections.sort(ans);

        for (Integer n : ans) {
            System.out.println(n);
        }
    }

    private void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visit[start]++;

        while (!q.isEmpty()) {
            int now = q.poll();
            for (Integer n : graph[now]) {
                if (visit[n] == -1) {
                    q.add(n);
                    visit[n] = visit[now] + 1;
                }
            }
        }
    }
}
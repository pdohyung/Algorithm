import java.util.*;
import java.io.*;

public class Main {
    static int v, e;
    static ArrayList<Integer>[] graph;
    static int[] color;
    static boolean isCycle;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder answer = new StringBuilder();

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            v = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());

            graph = new ArrayList[v + 1];
            for (int i = 1; i <= v; i++) graph[i] = new ArrayList<>();

            for (int i = 0; i < e; i++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                graph[start].add(end);
                graph[end].add(start);
            }

            isCycle = false;
            color = new int[v + 1];

            for (int i = 1; i <= v; i++) {
                if (color[i] != 0) continue;
                dfs(i, 1);
            }

            if (isCycle) {
                answer.append("NO\n");
            } else {
                answer.append("YES\n");
            }
        }

        System.out.println(answer);
    }

    private static void dfs(int start, int c) {
        color[start] = c;

        for (int next : graph[start]) {
            if (color[next] == 0) {
                dfs(next, -c);
            } else if (color[start] == color[next]) {
                isCycle = true;
            }
        }
    }
}

import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N + 1];

        dfs(0, 1, new StringBuilder());
    }

    private static void dfs(int depth, int idx, StringBuilder now) {
        if (depth == M) {
            System.out.println(now);
            return;
        }

        for (int i = idx; i <= N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                StringBuilder next = new StringBuilder(now);
                dfs(depth + 1, i, next.append(i).append(" "));
                visited[i] = false;
            }
        }
    }
}

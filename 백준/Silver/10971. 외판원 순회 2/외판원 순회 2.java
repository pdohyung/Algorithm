
import java.util.*;
import java.io.*;

public class Main {

    static int N, start, answer;
    static int[][] W;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        W = new int[N][N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                W[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        answer = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            start = i;
            visited[start] = true;
            dfs(0, i, 0);
            visited[start] = false;
        }

        System.out.println(answer);
    }

    static void dfs(int depth, int now, int sum) {
        if (depth == N - 1) {
            if (W[now][start] != 0) {
                answer = Math.min(answer, sum + W[now][start]);
            }
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i] && W[now][i] != 0) {
                visited[i] = true;
                dfs(depth + 1, i, sum + W[now][i]);
                visited[i] = false;
            }
        }
    }
}

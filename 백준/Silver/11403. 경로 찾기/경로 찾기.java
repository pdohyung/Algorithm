import java.util.*;
import java.io.*;

public class Main {

    static ArrayList<Integer>[] graph;
    static int[][] result;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] board = new int[N + 1][N + 1];
        result = new int[N + 1][N + 1];
        graph = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            graph[i] = new ArrayList<>();

            for (int j = 1; j <= N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (board[i][j] == 1) {
                    graph[i].add(j);
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            visited = new boolean[N + 1];
            dfs(i, i);
        }

        StringBuilder answer = new StringBuilder();

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                answer.append(result[i][j]).append(" ");
            }
            answer.append("\n");
        }

        System.out.println(answer);
    }

    private static void dfs(int start, int parent) {

        for (int next : graph[start]) {
            if (!visited[next]) {
                visited[next] = true;
                result[parent][next] = 1;
                dfs(next, parent);
            }
        }
    }
}

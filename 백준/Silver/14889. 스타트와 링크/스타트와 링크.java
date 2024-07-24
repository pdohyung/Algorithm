import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static int N, min;
    static boolean[] visited;
    static int[][] scores;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    void solution() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        min = Integer.MAX_VALUE;
        visited = new boolean[N];
        scores = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                scores[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);
        System.out.println(min);
    }

    static int calculate() {
        int team1 = 0;
        int team2 = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i] && visited[j]) {
                    team1 += scores[i][j];
                } else if (!visited[i] && !visited[j]) {
                    team2 += scores[i][j];
                }
            }
        }

        return Math.abs(team1 - team2);
    }

    static void dfs(int n, int idx) {
        if (n == N / 2) {
            int diff = calculate();
            min = Math.min(min, diff);
            return;
        }

        for (int i = idx; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(n + 1, i + 1);
                visited[i] = false;
            }
        }
    }
}
import java.io.*;
import java.util.*;

public class Main {

    static int N, min;
    static boolean[] visited;
    static int[][] stat;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        visited = new boolean[N];
        stat = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                stat[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        min = Integer.MAX_VALUE;
        dfs(0, 0);

        System.out.println(min);
    }

    private static void dfs(int depth, int idx) {
        if (depth == N / 2) {
//            System.out.println(Arrays.toString(visited));
            min = Math.min(cal(), min);
            return;
        }

        for (int i = idx; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(depth + 1, i + 1);
                visited[i] = false;
            }
        }
    }

    private static int cal() {
        int team1 = 0;
        int team2 = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i] && visited[j]) {
                    team1 += stat[i][j];
                } else if (!visited[i] && !visited[j]) {
                    team2 += stat[i][j];
                }
            }
        }

        return Math.abs(team1 - team2);
    }
}


import java.util.*;
import java.io.*;

public class Main {

    static int N, answer;
    static boolean[][] bad;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        bad = new boolean[N + 1][N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int f = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            bad[f][s] = true;
            bad[s][f] = true;
        }

        answer = 0;
        dfs(0, 1, new int[3]);

        System.out.println(answer);
    }

    static void dfs(int depth, int idx, int[] now) {
        if (depth == 3) {

            for (int i = 0; i < 3; i++) {
                for (int j = i + 1; j < 3; j++) {
                    if (bad[now[i]][now[j]]) {
                        return;
                    }
                }
            }

            answer++;
            return;
        }

        for (int i = idx; i <= N; i++) {
            now[depth] = i;
            dfs(depth + 1, i + 1, now);
        }
    }
}

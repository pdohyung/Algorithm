import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    static int N, M;
    static int[] res;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    void solution() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        res = new int[10];
        visit = new boolean[10];
        dfs(0);
    }

    private void dfs(int cnt) {
        if (cnt == M) {
            for (int i = 0; i < M; i++) {
                System.out.print(res[i] + " ");
            }
            System.out.println();
            return;
        }
        for (int i = 1; i <= N; i++) {
            if (!visit[i]) {
                res[cnt] = i;
                visit[i] = true;
                dfs(cnt + 1);
                visit[i] = false;
            }
        }
    }
}
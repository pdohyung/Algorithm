import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    static int N, M;
    static int[] res;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    void solution() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        res = new int[10];
        sb = new StringBuilder();
        dfs(1, 0);
        System.out.println(sb);
    }

    private void dfs(int start, int cnt) {
        if (cnt == M) {
            for (int i = 0; i < M; i++) {
                System.out.print(res[i] + " ");
            }
            System.out.println();
            return;
        }
        for (int i = start; i <= N; i++) {
            res[cnt] = i;
            dfs(i, cnt + 1);
        }
    }
}
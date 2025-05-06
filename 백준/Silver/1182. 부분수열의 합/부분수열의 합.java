import java.util.*;
import java.io.*;

public class Main {

    static int N, S, cnt;
    static int[] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        A = new int[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) A[i] = Integer.parseInt(st.nextToken());

        cnt = 0;

        dfs(0, 0, 0);

        System.out.println(cnt);
    }

    static void dfs(int depth, int idx, int now) {
        if (depth > 0 && now == S) cnt++;
        if (depth == N) return;

        for (int i = idx; i < N; i++) {
            dfs(depth + 1, i + 1, now + A[i]);
        }
    }
}

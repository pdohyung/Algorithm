
import java.util.*;
import java.io.*;

public class Main {

    static int N, M;
    static boolean[] broken;
    static int min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        broken = new boolean[10];

        if (M > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                broken[Integer.parseInt(st.nextToken())] = true;
            }
        }

        min = Math.abs(N - 100);
        dfs(0, "");

        System.out.println(min);
    }

    private static void dfs(int depth, String result) {
        if (depth > 6) {
            return;
        }

        if (!result.isEmpty()) {
            int now = Integer.parseInt(result);
            int cnt = result.length() + Math.abs(N - now);
            min = Math.min(min, cnt);
        }

        for (int i = 0; i <= 9; i++) {
            if (!broken[i]) {
                dfs(depth + 1, result + i);
            }
        }
    }
}

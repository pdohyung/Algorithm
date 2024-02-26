import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    static int N;
    static int[][] map;
    static long[][] dp;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    void solution() throws IOException {
        N = Integer.parseInt(br.readLine());
        map = new int[N + 1][N + 1];
        dp = new long[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[1][1] = 1;

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                int jumpLength = map[i][j];

                if (jumpLength == 0) break;

                if (i + jumpLength <= N) {
                    dp[i + jumpLength][j] += dp[i][j];
                }
                if (j + jumpLength <= N) {
                    dp[i][j + jumpLength] += dp[i][j];
                }
            }
        }

        System.out.println(dp[N][N]);
    }
}
import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    static int[][][] dp;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    void solution() throws IOException {
        dp = new int[100001][5][5];
        for (int i = 0; i < 100001; i++) {
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    dp[i][j][k] = 100001 * 5;
                }
            }
        }
        int[][] v = {
                {0, 2, 2, 2, 2},
                {2, 1, 3, 4, 3},
                {2, 3, 1, 3, 4},
                {2, 4, 3, 1, 3},
                {2, 3, 4, 3, 1}
        };
        int idx = 1;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        dp[0][0][0] = 0;

        while (n != 0) {
            for (int i = 0; i < 5; i++) {
                if (n == i) {
                    continue;
                }
                for (int j = 0; j < 5; j++) {
                    dp[idx][i][n] = Math.min(dp[idx - 1][i][j] + v[j][n], dp[idx][i][n]);
                }
            }

            for (int j = 0; j < 5; j++) {
                if (n == j) {
                    continue;
                }
                for (int i = 0; i < 5; i++) {
                    dp[idx][n][j] = Math.min(dp[idx - 1][i][j] + v[i][n], dp[idx][n][j]);
                }
            }

            idx++;
            n = Integer.parseInt(st.nextToken());
        }
        idx--;
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                res = Math.min(res, dp[idx][i][j]);
            }
        }
        System.out.println(res);
    }
}
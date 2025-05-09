
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] cost = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][][] dp = new int[N + 1][M + 1][3];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (j == 1) {
                    dp[i][j][0] = Math.min(dp[i - 1][j][1], dp[i - 1][j + 1][2]) + cost[i][j];
                    dp[i][j][1] = dp[i - 1][j + 1][2] + cost[i][j];
                    dp[i][j][2] = dp[i - 1][j][1] + cost[i][j];
                } else if (j == M) {
                    dp[i][j][0] = dp[i - 1][j][1] + cost[i][j];
                    dp[i][j][1] = dp[i - 1][j - 1][0] + cost[i][j];
                    dp[i][j][2] = Math.min(dp[i - 1][j - 1][0], dp[i - 1][j][1]) + cost[i][j];
                } else {
                    dp[i][j][0] = Math.min(dp[i - 1][j][1], dp[i - 1][j + 1][2]) + cost[i][j];
                    dp[i][j][1] = Math.min(dp[i - 1][j - 1][0], dp[i - 1][j + 1][2]) + cost[i][j];
                    dp[i][j][2] = Math.min(dp[i - 1][j - 1][0], dp[i - 1][j][1]) + cost[i][j];
                }
            }
        }

        int answer = Integer.MAX_VALUE;

        for (int i = 1; i <= M; i++) {
            for (int j = 0; j < 3; j++) {
                answer = Math.min(answer, dp[N][i][j]);
            }
        }

        System.out.println(answer);
    }
}


import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] cost = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) cost[i][j] = Integer.parseInt(st.nextToken());
        }

        int[][][] dp = new int[N][M][3];
        int[] dir = {-1, 0, 1};

        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++)
                Arrays.fill(dp[i][j], Integer.MAX_VALUE);

        for (int i = 0; i < M; i++) Arrays.fill(dp[0][i], cost[0][i]);

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int d = 0; d < 3; d++) {
                    int beforeCol = j + dir[d];
                    if (beforeCol < 0 || beforeCol >= M) continue;

                    for (int beforeDir = 0; beforeDir < 3; beforeDir++) {
                        if (beforeDir == d || dp[i - 1][beforeCol][beforeDir] == Integer.MAX_VALUE) continue;
                        dp[i][j][d] = Math.min(dp[i][j][d], dp[i - 1][beforeCol][beforeDir] + cost[i][j]);
                    }
                }
            }
        }

        int answer = Integer.MAX_VALUE;

        for (int j = 0; j < M; j++)
            for (int d = 0; d < 3; d++)
                answer = Math.min(answer, dp[N - 1][j][d]);

        System.out.println(answer);
    }
}

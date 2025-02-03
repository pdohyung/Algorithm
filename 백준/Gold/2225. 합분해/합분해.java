import java.util.*;
import java.io.*;

public class Main {

    static int N, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int MOD = 1_000_000_000;
        int[][] dp = new int[K + 1][N + 1];

        for (int i = 1; i <= N; i++) dp[1][i] = 1;
        for (int i = 1; i <= K; i++) dp[i][0] = 1;


        for (int i = 1; i <= K; i++) {
            for (int j = 1; j <= N; j++) {
                dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % MOD;
            }
        }

        System.out.println(dp[K][N]);
    }
}

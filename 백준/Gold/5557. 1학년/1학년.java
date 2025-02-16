
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N + 1];
        long[][] dp = new long[N + 1][21];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) A[i] = Integer.parseInt(st.nextToken());

        dp[0][A[1]] = 1;

        for (int i = 1; i < N; i++) {
            for (int j = 0; j <= 20; j++) {
                if (dp[i - 1][j] > 0 && j - A[i + 1] >= 0) dp[i][j - A[i + 1]] += dp[i - 1][j];
                if (dp[i - 1][j] > 0 && j + A[i + 1] <= 20) dp[i][j + A[i + 1]] += dp[i - 1][j];
            }
        }

        System.out.println(dp[N - 2][A[N]]);
    }
}

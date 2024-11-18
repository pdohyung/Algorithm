import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static long[][] dp;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        dp = new long[N + 1][10];

        for (int i = 1; i < 10; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= N; i++) {
            for (int j = 0; j < 10; j++) {
                if (j == 9) {
                    dp[i][j] = dp[i - 1][j - 1];
                    continue;
                }
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j + 1];
                    continue;
                }
                dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % 1_000_000_000;
            }
        }

        long answer = 0;

        for (int i = 0; i < 10; i++) {
            answer = (answer + dp[N][i]) % 1_000_000_000;
        }

        System.out.println(answer);
    }
}

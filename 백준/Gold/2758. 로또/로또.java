
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder answer = new StringBuilder();

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            long[][] dp = new long[m + 1][n + 1];

            for (int i = 1; i <= m; i++) dp[i][1] = 1;

            for (int i = 1; i <= m / 2; i++) {
                for (int j = i * 2; j <= m; j++) {
                    for (int k = 2; k <= n; k++) {
                        dp[j][k] += dp[i][k - 1];
                    }
                }
            }

            long result = 0;
            for (int i = 1; i <= m; i++) result += dp[i][n];
            answer.append(result).append("\n");
        }

        System.out.println(answer);
    }
}

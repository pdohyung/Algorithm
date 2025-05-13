
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder answer = new StringBuilder();

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            long[][] dp = new long[M + 1][N + 1];

            for (int i = 1; i <= M; i++) {
                dp[i][1] = 1;
            }

            for (int i = 1; i <= M / 2; i++) {
                for (int j = i * 2; j <= M; j++) {
                    for (int k = 2; k <= N; k++) {
                        dp[j][k] += dp[i][k - 1];
                    }
                }
            }

            long cnt = 0;

            for (int i = 1; i <= M; i++) {
                cnt += dp[i][N];
            }

            answer.append(cnt).append("\n");
        }

        System.out.println(answer);
    }
}

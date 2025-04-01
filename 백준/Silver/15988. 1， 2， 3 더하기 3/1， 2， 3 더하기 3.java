
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int MAX = 1_000_001;
        int MOD = 1_000_000_009;

        long[] dp = new long[MAX];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int i = 4; i < MAX; i++) {
            dp[i] = (dp[i - 3] + dp[i - 2] + dp[i - 1]) % MOD;
        }

        StringBuilder answer = new StringBuilder();

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            answer.append(dp[N]).append("\n");
        }

        System.out.println(answer);
    }
}

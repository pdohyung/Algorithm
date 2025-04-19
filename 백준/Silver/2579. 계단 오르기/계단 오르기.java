import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static int[] costs;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        costs = new int[N + 1];
        dp = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            int cost = Integer.parseInt(br.readLine());
            costs[i] = cost;
        }

        dp[1] = costs[1];
        if (N > 1) {
            dp[2] = dp[1] + costs[2];
        }

        for (int i = 3; i <= N; i++) {
            dp[i] = Math.max(dp[i - 2], dp[i - 3] + costs[i - 1]) + costs[i];
//            System.out.println(dp[i]);
        }
        System.out.println(dp[N]);
    }
}

import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        if (N == 0) {
            System.out.println(0);
            return;
        }

        dp = new int[N + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i - 2] + dp[i - 1];
        }

        System.out.println(dp[N]);
    }
}

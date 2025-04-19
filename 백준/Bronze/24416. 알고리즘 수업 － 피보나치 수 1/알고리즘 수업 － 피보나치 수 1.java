import java.util.*;
import java.io.*;

public class Main {

    static int[] dp;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        dp = new int[N + 2];
        dp[1] = 1;
        dp[2] = 1;

        System.out.println(fib(N) + " " + cnt);
    }

    private static int fib(int n) {
        if (n == 1 || n == 2) return dp[n];

        for (int i = 3; i <= n; i++) {
            cnt++;
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }
}

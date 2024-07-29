import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static int N, cnt;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    void solution() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        cnt = 0;
        dp = new int[N + 1];
        dp[1] = 1;
        dp[2] = 1;
        System.out.println(fib(N) + " " + cnt);
    }

    static int fib(int n) {
        if (n == 1 || n == 2) {
            return dp[n];
        }
        for (int i = 3; i <= n; i++) {
            cnt++;
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

}
import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static int N;
    static long[] dp;
    static long[] p;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    void solution() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        p = new long[N + 1];
        dp = new long[N + 1];
        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            p[i] = Integer.parseInt(st.nextToken());
            dp[i] = p[i];
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= i; j++) {
                //System.out.println(i + " " + j + " " +  dp[i]);
                dp[i] = Math.min(dp[i], dp[i - j] + p[j]);
            }
            //System.out.println(dp[i]);
        }

        System.out.println(dp[N]);
    }

}
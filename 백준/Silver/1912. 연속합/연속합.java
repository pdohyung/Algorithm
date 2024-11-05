import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static int[] dp, num;
    static int N, max;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        dp = new int[N + 1];
        num = new int[N + 1];
        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        
        max = num[1];
        
        for (int i = 1; i <= N; i++) {
            dp[i] = Math.max(dp[i - 1] + num[i], num[i]);
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
    }
}

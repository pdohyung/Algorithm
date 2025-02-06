
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] dp = new int[k + 1];
        int[] coins = new int[n];
        dp[0] = 1;

        for (int i = 0; i < n; i++) {
            int coin = Integer.parseInt(br.readLine());
            coins[i] = coin;
        }

        for (int i = 0; i < n; i++) {
            int coin = coins[i];

            for (int j = coin; j <= k; j++) {
                dp[j] += dp[j - coin];
//                System.out.println(j + " " + dp[j]);
            }
//            System.out.println();
        }
//        System.out.println(Arrays.toString(dp));
        System.out.println(dp[k]);
    }
}

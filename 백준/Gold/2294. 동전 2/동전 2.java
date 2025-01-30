
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Set<Integer> coins = new HashSet<>();
        int[] dp = new int[k + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        for (int i = 0; i < n; i++) {
            int coin = Integer.parseInt(br.readLine());
            coins.add(coin);
            if (coin <= k) {
                dp[coin] = 1;
            }
        }

//        System.out.println(Arrays.toString(dp));

        for (int i = 1; i <= k; i++) {
            for (int coin : coins) {
                if (i - coin > 0 && dp[i - coin] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

//        System.out.println(Arrays.toString(dp));
        
        if (dp[k] == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(dp[k]);
        }
    }
}

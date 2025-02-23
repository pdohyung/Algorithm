
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] line = br.readLine().toCharArray();

        if (line[0] == '0') {
            System.out.println(0);
            return;
        }

        int[] dp = new int[line.length + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i < dp.length; i++) {
            int before = line[i - 2] - 48;
            int now = line[i - 1] - 48;

            if (before > 2 && now == 0) {
                System.out.println(0);
                return;
            }

            int num = before * 10 + now;

            if (now > 0) dp[i] += dp[i - 1];
            if (num >= 10 && num <= 26) dp[i] += dp[i - 2];

            dp[i] %= 1_000_000;
        }

        System.out.println(dp[line.length]);
    }
}

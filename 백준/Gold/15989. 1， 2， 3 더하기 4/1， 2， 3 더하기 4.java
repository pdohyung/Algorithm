
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[] result = new int[T];
        int max = 0;

        for (int i = 0; i < T; i++) {
            result[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, result[i]);
        }

        int[] dp = new int[max + 1];
        dp[0] = 1;

        for (int i = 1; i <= 3; i++) {
            for (int j = i; j <= max; j++) {
                dp[j] += dp[j - i];
            }
        }

        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < T; i++) answer.append(dp[result[i]]).append("\n");

        System.out.println(answer);
    }
}

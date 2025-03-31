
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1];

        List<Integer> vips = new ArrayList<>();
        for (int i = 0; i < M; i++) vips.add(Integer.parseInt(br.readLine()));

        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        int answer = 1;
        int before = 0;

        for (int i = 0; i < M; i++) {
            int vip = vips.get(i);
            int len = vip - before - 1;
            answer *= dp[len];
            before = vip;
        }

        System.out.println(answer * dp[N - before]);
    }
}


import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] T = new int[N + 1];
        int[] P = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N + 2];
        int answer = 0;

        for (int i = 1; i <= N; i++) {
            // 이전 상담을 하지 않는 경우를 고려
            dp[i] = Math.max(dp[i], dp[i - 1]);

            int next = i + T[i];
            if (next > N + 1) continue;

            dp[next] = Math.max(dp[next], dp[i] + P[i]);
            answer = Math.max(answer, dp[next]);
        }

        System.out.println(answer);
    }
}

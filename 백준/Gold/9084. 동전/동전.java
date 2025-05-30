
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder answer = new StringBuilder();

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[] A = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) A[i] = Integer.parseInt(st.nextToken());

            int target = Integer.parseInt(br.readLine());
            int[] dp = new int[target + 1];
            dp[0] = 1;

            for (int i = 0; i < N; i++) {
                int now = A[i];
                for (int j = now; j <= target; j++) {
                    dp[j] += dp[j - now];
                }
            }
            answer.append(dp[target]).append("\n");
        }

        System.out.println(answer);
    }
}


import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] A = new int[N + 1];
        boolean[] dp = new boolean[N + 1];
        dp[1] = true;

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) A[i] = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            if (!dp[i]) continue;
            for (int j = i + 1; j <= N; j++) {
                int cost = (j - i) * (1 + Math.abs(A[i] - A[j]));
                if (cost <= K) dp[j] = true;
            }
        }

        if (dp[N]) System.out.println("YES");
        else System.out.println("NO");
    }
}

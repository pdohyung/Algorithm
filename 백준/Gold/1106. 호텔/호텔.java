
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[][] A = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            A[i][0] = Integer.parseInt(st.nextToken()); // 홍보 비용
            A[i][1] = Integer.parseInt(st.nextToken()); // 얻는 고객의 수
        }

        long[] dp = new long[C + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 0; i < N; i++) {
            int[] c = A[i];
            int cost = c[0];
            int people = c[1];

            for (int j = people; j <= C + people; j++) {
                if (j > C) {
                    dp[C] = Math.min(dp[C], dp[j - people] + cost);
                    continue;
                }
                dp[j] = Math.min(dp[j], dp[j - people] + cost);
            }
        }

        System.out.println(dp[C]);
    }
}

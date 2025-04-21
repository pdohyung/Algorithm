
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        List<int[]> lines = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            lines.add(new int[]{s, e});
        }

        Collections.sort(lines, (a, b) -> Integer.compare(a[0], b[0]));

        int[] dp = new int[lines.size()];
        Arrays.fill(dp, 1);
        int cnt = 0;

        for (int i = 0; i < lines.size(); i++) {
            int[] now = lines.get(i);

            for (int j = 0; j < i; j++) {
                int[] next = lines.get(j);

                if (next[1] < now[1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

            cnt = Math.max(cnt, dp[i]);
        }

        System.out.println(lines.size() - cnt);
    }
}

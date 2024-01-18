import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    static long[] S;
    static long[] C;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    void solution() throws IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        S = new long[n];
        C = new long[m];
        long ans = 0;
        st = new StringTokenizer(br.readLine());

        S[0] = Integer.parseInt(st.nextToken());
        for (int i = 1; i < n; i++) {
            S[i] = S[i - 1] + Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            int result = (int) (S[i] % m);
            if (result == 0) {
                ans++;
            }
            C[result]++;
        }

        for (int i = 0; i < m; i++) {
            if (C[i] > 1) {
                ans += (C[i] * (C[i] - 1) / 2);
            }
        }
        System.out.println(ans);
    }
}
import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    static long[] D;
    static long[] A;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    void solution() throws IOException {
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        D = new long[n + 1];
        A = new long[n + 1];
        long max = Integer.MIN_VALUE;

        for (int i = 1; i <= n; i++) {
            A[i] = Long.parseLong(st.nextToken());
        }

        for (int i = 1; i <= n; i++) {
            D[i] = Math.max(D[i - 1] + A[i], A[i]);
            max = Math.max(max, D[i]);
        }
        System.out.println(max);
    }
}

import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    static long[] L;
    static long[] R;
    static long[] A;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    void solution() throws IOException {
        int N = Integer.parseInt(br.readLine());
        A = new long[N + 1];
        L = new long[N + 1];
        R = new long[N + 1];
        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        L[1] = A[1];
        long res = A[1];

        for (int i = 2; i <= N; i++) {
            L[i] = Math.max(A[i], L[i - 1] + A[i]);
            res = Math.max(res, L[i]);
        }

        R[N] = A[N];

        for (int i = N - 1; i > 0; i--) {
            R[i] = Math.max(A[i], R[i + 1] + A[i]);
        }

        for (int i = 2; i < N; i++) {
            res = Math.max(res, L[i - 1] + R[i + 1]);
        }

        System.out.println(res);
    }
}
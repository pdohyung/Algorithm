import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    static int[] A;
    static int[] D;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    void solution() throws IOException {
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        A = new int[N + 1];
        D = new int[N + 1];
        int max = 0;

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            D[i] = A[i];
            for (int j = 0; j < i; j++) {
                if (A[j] < A[i] && D[i] < D[j] + A[i]) {
                    D[i] = D[j] + A[i];
                }
            }
        }

        for (int i = 0; i < N; i++) {
            max = Math.max(max, D[i]);
        }

        System.out.println(max);
    }
}
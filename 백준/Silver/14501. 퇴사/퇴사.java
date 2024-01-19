import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    static int[] T;
    static int[] P;
    static int[] D;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    void solution() throws IOException {
        int N = Integer.parseInt(br.readLine());
        T = new int[N + 1];
        P = new int[N + 1];
        D = new int[N + 2];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = N; i > 0; i--) {
            if (T[i] + i > N + 1) {
                D[i] = D[i + 1];
                continue;
            }
            D[i] = Math.max(D[i + 1], D[i + T[i]] + P[i]);
        }
        System.out.println(D[1]);
    }
}
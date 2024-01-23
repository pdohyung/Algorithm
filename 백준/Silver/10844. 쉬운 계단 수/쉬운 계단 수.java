import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    static long[][] D;
    static long mod = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    void solution() throws IOException {
        int N = Integer.parseInt(br.readLine());
        D = new long[N + 1][10];

        for (int i = 1; i < 10; i++) {
            D[1][i] = 1;
        }

        for (int i = 2; i <= N; i++) {
            for (int j = 0; j < 10; j++) {
                if (j == 0) {
                    D[i][j] = D[i - 1][j + 1];
                    continue;
                }
                if (j == 9) {
                    D[i][j] = D[i - 1][j - 1];
                    continue;
                }
                D[i][j] = (D[i - 1][j - 1] + D[i - 1][j + 1]) % mod;
            }
        }
        long res = 0;
        for (int i = 0; i < 10; i++) {
            res = (res + D[N][i]) % mod;
        }
        System.out.println(res);
    }
}
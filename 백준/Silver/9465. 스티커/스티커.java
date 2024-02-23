import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st1, st2;
    static int[][] D;
    static int[][] val;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    void solution() throws IOException {
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            st1 = new StringTokenizer(br.readLine());
            st2 = new StringTokenizer(br.readLine());
            val = new int[2][N];
            D = new int[2][N];

            for (int i = 0; i < N; i++) {
                val[0][i] = Integer.parseInt(st1.nextToken());
                val[1][i] = Integer.parseInt(st2.nextToken());
            }

            D[0][0] = val[0][0];
            D[1][0] = val[1][0];
            int max = Math.max(D[0][0], D[1][0]);

            for (int i = 1; i < N; i++) {
                if (i == 1) {
                    D[0][i] = D[1][0] + val[0][i];
                    D[1][i] = D[0][0] + val[1][i];
                    max = Math.max(D[0][i], D[1][i]);
                    continue;
                }

                D[0][i] = Math.max(D[1][i - 1], D[1][i - 2]) + val[0][i];
                D[1][i] = Math.max(D[0][i - 1], D[0][i - 2]) + val[1][i];
                max = Math.max(D[0][i], D[1][i]);
            }
            System.out.println(max);
        }
    }
}
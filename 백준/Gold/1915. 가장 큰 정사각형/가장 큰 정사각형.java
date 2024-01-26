import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    static long[][] D;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    void solution() throws IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        D = new long[n + 1][m + 1];
        long max = 0;

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                D[i][j] = Long.parseLong(String.valueOf(line.charAt(j)));
                if (D[i][j] == 1 && i > 0 && j > 0) {
                    D[i][j] = Math.min(Math.min(D[i - 1][j], D[i][j - 1]), D[i - 1][j - 1]) + D[i][j];
                }
                max = Math.max(max, D[i][j]);
            }
        }

        System.out.println(max * max);
    }
}
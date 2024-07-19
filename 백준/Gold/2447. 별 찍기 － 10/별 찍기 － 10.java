import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static String[][] map;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    void solution() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        map = new String[N][N];
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            Arrays.fill(map[i], " ");
        }
        solve(0, 0, N);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void solve(int x, int y, int n) {
        if (n == 1) {
            map[x][y] = "*";
            return;
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (!(i == 1 && j == 1)) {
                    solve(x + i * (n / 3), y + j * (n / 3), n / 3);
                }
            }
        }
    }

}
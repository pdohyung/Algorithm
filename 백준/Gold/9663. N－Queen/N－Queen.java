import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static int N;
    static boolean[] dia1, dia2, col;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    void solution() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        col = new boolean[N];
        dia1 = new boolean[2 * N];
        dia2 = new boolean[2 * N];

        int answer = dfs(0);
        System.out.println(answer);
    }

    static int dfs(int y) {
        int result = 0;

        if (y == N) {
            result++;
        } else {
            for (int i = 0; i < N; i++) {
                if (dia1[i + y] || dia2[i - y + N] || col[i]) {
                    continue;
                }
                dia1[i + y] = dia2[i - y + N] = col[i] = true;
                result += dfs(y + 1);
                dia1[i + y] = dia2[i - y + N] = col[i] = false;
            }
        }
        return result;
    }

}
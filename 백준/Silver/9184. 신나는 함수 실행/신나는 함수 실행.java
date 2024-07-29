import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static int N;
    static int[][][] dp;
    static boolean[][][] visited;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    void solution() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        dp = new int[101][101][101];
        visited = new boolean[101][101][101];

        while (true) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a == -1 && b == -1 && c == -1) {
                break;
            }

            System.out.println("w(" + a + ", " + b + ", " + c + ") = " + w(a, b, c));
        }

    }

    static int w(int a, int b, int c) {
        int aa = a + 50;
        int bb = b + 50;
        int cc = c + 50;

        if (visited[aa][bb][cc]) {
            return dp[aa][bb][cc];
        }

        if (a <= 0 || b <= 0 || c <= 0) {
            visited[aa][bb][cc] = true;
            return dp[aa][bb][cc] = 1;
        } else if (a > 20 || b > 20 || c > 20) {
            visited[aa][bb][cc] = true;
            return dp[aa][bb][cc] = w(20, 20, 20);
        } else if (a < b && b < c) {
            visited[aa][bb][cc] = true;
            return dp[aa][bb][cc] = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
        } else {
            visited[aa][bb][cc] = true;
            return dp[aa][bb][cc] = w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
        }
    }

}
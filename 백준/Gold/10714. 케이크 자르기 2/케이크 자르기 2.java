import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static int[] cake;
    static long[][] dp;


    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    void solution() throws IOException {
        N = Integer.parseInt(br.readLine());
        cake = new int[N];
        dp = new long[N + 1][N + 1];

        for (int i = 0; i < N; i++) {
            cake[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], -1);
        }

        long ans = 0;
        for (int i = 0; i < N; i++) {
            ans = Math.max(ans, cake[i] + ioi(i, i));
        }

        System.out.println(ans);
        return;
    }

    static long ioi(int left, int right) {
        if (goRight(right) == left) {
            return 0;
        }

        if (cake[goLeft(left)] > cake[goRight(right)]) {
            return joi(goLeft(left), right);
        }

        return joi(left, goRight(right));
    }

    static long joi(int left, int right) {
        if (goRight(right) == left) {
            return dp[left][right] = 0;
        }

        if (dp[left][right] != -1) {
            return dp[left][right];
        }

        long leftV = cake[goLeft(left)] + ioi(goLeft(left), right);
        long rightV = cake[goRight(right)] + ioi(left, goRight(right));

        return dp[left][right] = Math.max(leftV, rightV);
    }

    static int goLeft(int left) {
        return (left + N - 1) % N;
    }

    static int goRight(int right) {
        return (right + 1) % N;
    }

}

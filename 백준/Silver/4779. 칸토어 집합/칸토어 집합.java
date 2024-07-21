import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static int N;
    static StringBuilder answer;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    void solution() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while ((s = br.readLine()) != null) {
            N = Integer.parseInt(s);
            answer = new StringBuilder();
            int len = (int) Math.pow(3, N);
            answer.append("-".repeat(Math.max(0, len)));
            solve(0, len);
            System.out.println(answer);
        }
    }

    static void solve(int start, int n) {
        if (n == 1) {
            return;
        }

        int size = n / 3;

        for (int i = size + start; i < 2 * size + start; i++) {
            answer.setCharAt(i, ' ');
        }

        solve(start, size);
        solve(2 * size + start, size);
    }
}
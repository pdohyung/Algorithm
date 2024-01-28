import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    static int[] alpha;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    void solution() throws IOException {
        int N = Integer.parseInt(br.readLine());
        int ans = 0;
        for (int i = 0; i < N; i++) {
            int max = 0;
            alpha = new int[26];
            char t = '0';
            for (char c : br.readLine().toCharArray()) {
                if (t != c) {
                    max = Math.max(max, ++alpha[c - 97]);
                }
                t = c;
            }
            if (max > 1) {
                continue;
            }
            ans++;
        }
        System.out.println(ans);
    }
}
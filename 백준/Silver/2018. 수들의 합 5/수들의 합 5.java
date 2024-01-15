import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    void solution() throws IOException {
        int n = Integer.parseInt(br.readLine());
        int startIdx = 0;
        int endIdx = 0;
        int sum = 0;
        int ans = 0;

        while (startIdx <= n) {
            if (sum == n) {
                ans++;
                endIdx++;
                sum += endIdx;
                continue;
            }
            if (sum < n) {
                endIdx++;
                sum += endIdx;
                continue;
            }
            if (sum > n) {
                sum -= startIdx;
                startIdx++;
            }
        }
        System.out.println(ans);
    }
}
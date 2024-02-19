import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    static int[] numbers;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    void solution() throws IOException {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        numbers = new int[N];

        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        int odd = 0, even = 0, L = 0, R = 0;

        if (numbers[0] % 2 == 0) {
            even++;
        } else {
            odd++;
        }

        int res = even;

        while (R >= L) {
            if (odd > K) {
                if (numbers[L] % 2 == 0) {
                    even--;
                } else {
                    odd--;
                }
                L++;
            } else {
                R++;
                if (R >= N) break;
                if (numbers[R] % 2 == 0) {
                    even++;
                } else {
                    odd++;
                }
                res = Math.max(res, even);
            }
        }
        System.out.println(res);
    }
}
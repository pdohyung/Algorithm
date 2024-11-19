import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static int N, K;
    static int[] num, S;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        num = new int[N + 1];
        S = new int[N + 1];

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
            S[i] = S[i - 1] + num[i];
        }

        int max = Integer.MIN_VALUE;

        for (int i = K; i <= N; i++) {
            int now = S[i] - S[i - K];
            max = Math.max(max, now);
        }

        System.out.println(max);
    }
}

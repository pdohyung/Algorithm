import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int K;
    static int answer;
    static int[] numbers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        numbers = new int[K];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < K; i++) numbers[i] = Integer.parseInt(st.nextToken());

        answer = 0;
        dfs(0);

        System.out.println(answer);
    }

    private static void dfs(int now) {
        if (now > N) return;

        answer = Math.max(answer, now);

        for (int i = 0; i < K; i++) {
            dfs(now * 10 + numbers[i]);
        }
    }
}

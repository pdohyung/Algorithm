import java.util.*;
import java.io.*;

public class Main {

    static String N;
    static int K;
    static int answer;
    static int[] numbers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = st.nextToken();
        K = Integer.parseInt(st.nextToken());
        numbers = new int[K];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < K; i++) numbers[i] = Integer.parseInt(st.nextToken());

        answer = 0;
        dfs(0, new StringBuilder());

        System.out.println(answer);
    }

    private static void dfs(int depth, StringBuilder now) {
        if (depth > 0) {
            int result = Integer.parseInt(now.toString());
            if (result <= Integer.parseInt(N)) {
                answer = Math.max(answer, result);
            }
        }
        if (depth == N.length()) return;

        for (int i = 0; i < K; i++) {
            now.append(numbers[i]);
            dfs(depth + 1, now);
            now.deleteCharAt(now.length() - 1);
        }
    }
}

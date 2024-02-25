import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    static int N, M;
    static int[] numbers;
    static int[] result;
    static Set<String> answer;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    void solution() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        numbers = new int[N];
        result = new int[M];
        answer = new LinkedHashSet<>();

        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(numbers);
        dfs(0);
        answer.forEach(System.out::println);
    }

    private void dfs(int cnt) {
        if (cnt == M) {
            sb = new StringBuilder();
            for (int i = 0; i < M; i++) {
                sb.append(result[i]).append(" ");
            }
            answer.add(sb.toString());
            return;
        }

        for (int i = 0; i < N; i++) {
            result[cnt] = numbers[i];
            dfs(cnt + 1);
        }
    }
}
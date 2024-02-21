import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    static int N, M;
    static int[] numbers;
    static boolean[] visit;
    static int[] res;
    static Set<String> ans;
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
        visit = new boolean[N];
        res = new int[M];
        sb = new StringBuilder();
        ans = new LinkedHashSet<>();

        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(numbers);
        dfs(0, 0);
        ans.forEach(System.out::println);
    }

    private void dfs(int start, int cnt) {
        if (cnt == M) {
            sb = new StringBuilder();
            for (int i = 0; i < M; i++) {
                sb.append(res[i]).append(" ");
            }
            ans.add(sb.toString());
            return;
        }

        for (int i = start; i < N; i++) {
            if (!visit[i]) {
                res[cnt] = numbers[i];
                visit[i] = true;
                dfs(i, cnt + 1);
                visit[i] = false;
            }
        }
    }
}
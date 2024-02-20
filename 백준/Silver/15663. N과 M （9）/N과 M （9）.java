import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    static int N, M;
    static int[] numbers;
    static boolean[] visit;
    static int[] res;
    static List<String> ans;
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
        ans = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(numbers);
        dfs(0);

        for (int i = 0; i < ans.size(); i++) {
            System.out.println(ans.get(i));
        }
    }

    private void dfs(int cnt) {
        if (cnt == M) {
            sb = new StringBuilder();
            for (int i = 0; i < M; i++) {
                sb.append(res[i]).append(" ");
            }
            if (!ans.contains(sb.toString())) {
                ans.add(sb.toString());
            }
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visit[i]) {
                res[cnt] = numbers[i];
                visit[i] = true;
                dfs(cnt + 1);
                visit[i] = false;
            }
        }
    }
}
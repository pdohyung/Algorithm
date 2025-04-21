
import java.util.*;
import java.io.*;

public class Main {

    static int[] students;
    static boolean[] visited, finished;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            students = new int[n + 1];
            visited = new boolean[n + 1];
            finished = new boolean[n + 1];
            for (int i = 1; i <= n; i++) students[i] = Integer.parseInt(st.nextToken());

            cnt = 0;

            for (int i = 1; i <= n; i++) {
                if (!visited[i]) dfs(i);
            }

            System.out.println(n - cnt);
        }
    }

    static void dfs(int now) {
        visited[now] = true;
        int next = students[now];

        if (!visited[next]) {
            dfs(next);
        } else if (!finished[next]) {
            int temp = next;
            cnt++;
            while (temp != now) {
                temp = students[temp];
                cnt++;
            }
        }

        finished[now] = true;
    }
}

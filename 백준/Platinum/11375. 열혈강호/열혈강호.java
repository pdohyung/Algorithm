import java.util.*;
import java.io.*;

public class Main {

    static int N, M, answer;
    static boolean[] visited;
    static int[] job;
    static ArrayList<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());
            for (int j = 0; j < cnt; j++) graph[i].add(Integer.parseInt(st.nextToken()));
        }

        job = new int[M + 1];
        Arrays.fill(job, 0);

        for (int i = 1; i <= N; i++) {
            visited = new boolean[M + 1];
            if (dfs(i)) answer++;
        }

        System.out.println(answer);
    }

    private static boolean dfs(int worker) {
        for (int task : graph[worker]) {
            if (visited[task]) continue;
            visited[task] = true;

            if (job[task] == 0 || dfs(job[task])) {
                job[task] = worker;
                return true;
            }
        }

        return false;
    }
}

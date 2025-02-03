import java.util.*;
import java.io.*;

public class Main {

    static int N, target, answer, root;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        target = Integer.parseInt(br.readLine());
        visited = new boolean[N];
        graph = new ArrayList[N];
        for (int i = 0; i < N; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int parent = Integer.parseInt(st.nextToken());

            if (parent == -1) {
                root = i;
            } else {
                graph[parent].add(i);
            }
        }

        if (target == root) {
            System.out.println(0);
            return;
        }

        for (int i = 0; i < N; i++) {
            graph[i].remove(Integer.valueOf(target));
        }

        answer = 0;
        dfs(root);
        System.out.println(answer);
    }

    private static void dfs(int start) {
        if (graph[start].isEmpty()) {
            answer++;
            return;
        }

        for (int next : graph[start]) {
            dfs(next);
        }
    }
}

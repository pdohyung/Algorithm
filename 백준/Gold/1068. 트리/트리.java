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
                continue;
            }

            graph[parent].add(i);
        }

//        for (int i = 0; i < N; i++) {
//            System.out.println(graph[i]);
//        }
        graph[target] = new ArrayList<>();
        visited[target] = true;
        for (int i = 0; i < N; i++) {
            graph[i].remove(Integer.valueOf(target));
        }
//        System.out.println(Arrays.toString(visited));
//        for (int i = 0; i < N; i++) {
//            System.out.println(graph[i]);
//        }
        answer = 0;
        dfs(root);
//        System.out.println(Arrays.toString(visited));
        System.out.println(answer);
    }

    private static void dfs(int start) {
        if (visited[start]) {
            return;
        }

        visited[start] = true;

        if (graph[start].isEmpty()) {
            answer++;
            return;
        }

        for (int next : graph[start]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }
}

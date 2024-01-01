import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static boolean[] visited;
    static ArrayList<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int computers = Integer.parseInt(br.readLine());
        int edges = Integer.parseInt(br.readLine());
        visited = new boolean[computers + 1];
        graph = new ArrayList[computers + 1];

        for (int i = 1; i < computers + 1; i++) {
            graph[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < edges; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            graph[start].add(end);
            graph[end].add(start);
        }


        dfs(graph[1], 1);

        int count = 0;
        for (int i = 1; i < computers + 1; i++) {
            if (visited[i]) {
                count++;
            }
        }
        System.out.println(count - 1);
    }

    private static void dfs(List<Integer> computer, int node) {
        if (visited[node]) {
            return;
        }
        visited[node] = true;
        for (Integer i : computer) {
            dfs(graph[i], i);
        }
    }
}

import java.util.*;
import java.io.*;

public class Main {

    static ArrayList<Integer>[] graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder answer = new StringBuilder();

        for (int t = 0; t < T; t++) {
            int store = Integer.parseInt(br.readLine());
            int n = store + 2;
            int[][] distances = new int[n][2];
            graph = new ArrayList[n];

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                distances[i][0] = x;
                distances[i][1] = y;

                graph[i] = new ArrayList<>();
            }

            for (int i = 0; i < n - 1; i++) {
                for (int j = i + 1; j < n; j++) {
                    int distance = Math.abs(distances[i][0] - distances[j][0]) + Math.abs(distances[i][1] - distances[j][1]);

                    if (distance > 1000) continue;

                    graph[i].add(j);
                    graph[j].add(i);
                }
            }
//            for (int i = 0; i < n; i++) {
//                System.out.println(graph[i]);
//            }
            visited = new boolean[n];
            dfs(0);

            if (visited[n - 1]) {
                answer.append("happy");
            } else {
                answer.append("sad");
            }
            answer.append("\n");
        }
        System.out.println(answer);
    }

    private static void dfs(int start) {
        visited[start] = true;

        for(int next : graph[start]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }
}

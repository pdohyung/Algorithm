
import java.util.*;
import java.io.*;

public class Main {

    static ArrayList<Integer>[] graph;
    static int[] color;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine());
        StringBuilder answer = new StringBuilder();

        for (int k = 0; k < K; k++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            color = new int[V + 1];
            graph = new ArrayList[V + 1];
            for (int i = 1; i <= V; i++) graph[i] = new ArrayList<>();

            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                graph[s].add(e);
                graph[e].add(s);
            }

            String result = "YES";

            for (int i = 1; i <= V; i++) {
                if (color[i] != 0) continue;

                if (bfs(i)) {
                    result = "NO";
                    break;
                }
            }
            
            answer.append(result).append("\n");
        }

        System.out.println(answer);
    }

    static boolean bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        color[start] = 1;

        while (!q.isEmpty()) {
            int now = q.poll();

            for (int next : graph[now]) {
                if (color[next] == 0) {
                    color[next] = color[now] * -1;
                    q.offer(next);
                } else if (color[next] == color[now]) {
                    return true;
                }
            }
        }

        return false;
    }
}

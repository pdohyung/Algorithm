import java.io.*;
import java.util.*;

class Node {
    int to;
    int cost;

    public Node(int to, int cost) {
        this.to = to;
        this.cost = cost;
    }
}

public class Main {

    static ArrayList<Node>[] graph;
    static int N, answer, last;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        graph = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());

            while (true) {
                int end = Integer.parseInt(st.nextToken());

                if (end == -1) break;

                int len = Integer.parseInt(st.nextToken());
                graph[start].add(new Node(end, len));
            }
        }

        answer = Integer.MIN_VALUE;

        visited = new boolean[N + 1];
        dfs(1, 0);

        visited = new boolean[N + 1];
        dfs(last, 0);

        System.out.println(answer);
    }

    private static void dfs(int start, int dist) {
        visited[start] = true;

        if (dist > answer) {
            answer = dist;
            last = start;
        }

        for (Node next : graph[start]) {
            int nextTo = next.to;
            if (!visited[nextTo]) {
                visited[nextTo] = true;
                dfs(nextTo, dist + next.cost);
            }
        }
    }
}

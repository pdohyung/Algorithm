
import java.util.*;
import java.io.*;

class Node {
    int from, to, cost;

    public Node(int from, int to, int cost) {
        this.from = from;
        this.to = to;
        this.cost = cost;
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Node> edges = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int f = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            edges.add(new Node(f, t, c));
        }

        long[] dist = new long[N + 1];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[1] = 0;

        for (int i = 1; i <= N - 1; i++) {
            for (Node edge : edges) {
                int from = edge.from;
                int to = edge.to;
                int cost = edge.cost;

                if (dist[from] != Long.MAX_VALUE && dist[to] > dist[from] + cost) {
                    dist[to] = dist[from] + cost;
                }
            }
        }

        for (Node edge : edges) {
            int from = edge.from;
            int to = edge.to;
            int cost = edge.cost;

            if (dist[from] != Long.MAX_VALUE && dist[to] > dist[from] + cost) {
                System.out.println(-1);
                return;
            }
        }

        StringBuilder answer = new StringBuilder();

        for (int i = 2; i <= N; i++) {
            if (dist[i] == Long.MAX_VALUE) answer.append(-1);
            else answer.append(dist[i]);
            answer.append("\n");
        }

        System.out.println(answer);
    }
}

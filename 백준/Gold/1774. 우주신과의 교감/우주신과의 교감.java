
import java.util.*;
import java.io.*;

class Edge {
    int from, to;
    double cost;

    public Edge(int from, int to, double cost) {
        this.from = from;
        this.to = to;
        this.cost = cost;
    }
}

public class Main {

    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<long[]> gods = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            gods.add(new long[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }

        List<Edge> edges = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            long[] god1 = gods.get(i);
            for (int j = i + 1; j < N; j++) {
                long[] god2 = gods.get(j);
                long x = Math.abs(god1[0] - god2[0]);
                long y = Math.abs(god1[1] - god2[1]);
                double cost = Math.sqrt(x * x + y * y);
                edges.add(new Edge(i + 1, j + 1, cost));
            }
        }

        edges.sort(Comparator.comparing(e -> e.cost));

        int cnt = 0;
        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if (find(x) != find(y)) {
                cnt++;
                union(x, y);
            }
        }

        double cost = 0;

        for (Edge e : edges) {
            if (find(e.from) != find(e.to)) {
                cnt++;
                cost += e.cost;
                union(e.from, e.to);
            }

            if (cnt == N - 1) {
                break;
            }
        }

        String answer = String.format("%.2f", cost);
        System.out.println(answer);
    }

    static int find(int x) {
        if (x != parent[x]) parent[x] = find(parent[x]);
        return parent[x];
    }

    static void union(int x, int y) {
        int rX = find(x);
        int rY = find(y);
        if (rX != rY) parent[rY] = rX;
    }
}

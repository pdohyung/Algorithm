
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

        int n = Integer.parseInt(br.readLine());
        List<double[]> stars = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            stars.add(new double[]{Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken())});
        }

        List<Edge> edges = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            double[] from = stars.get(i);
            for (int j = i + 1; j < n; j++) {
                double[] to = stars.get(j);
                double x = Math.abs(from[0] - to[0]);
                double y = Math.abs(from[1] - to[1]);
                double cost = Math.sqrt(x * x + y * y);
                edges.add(new Edge(i, j, cost));
            }
        }

        Collections.sort(edges, Comparator.comparing(e -> e.cost));

        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        int N = 0;
        double cost = 0;

        for (Edge e : edges) {
            if (find(e.from) != find(e.to)) {
                N++;
                cost += e.cost;
                union(e.from, e.to);
            }

            if (N == n - 1) {
                break;
            }
        }

        System.out.printf("%.2f", cost);
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

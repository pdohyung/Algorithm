
import java.util.*;
import java.io.*;

class Edge {
    int from, to, cost;

    public Edge(int from, int to, int cost) {
        this.from = from;
        this.to = to;
        this.cost = cost;
    }
}

public class Main {

    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 모든 집을 갈 수 있는 최소 길에 대해서 가로등을 키고, 나머지는 끌 때 아낄 수 있는 액수 출력
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        StringBuilder answer = new StringBuilder();

        while (m != 0 && n != 0) {
            parent = new int[m];
            for (int i = 0; i < m; i++) {
                parent[i] = i;
            }

            int total = 0;
            List<Edge> edges = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());
                edges.add(new Edge(from, to, cost));
                total += cost;
            }

            Collections.sort(edges, Comparator.comparing(e -> e.cost));

            int N = 0;

            for (Edge e : edges) {
                if (find(e.from) != find(e.to)) {
                    N++;
                    total -= e.cost;
                    union(e.from, e.to);
                }

                if (N == n - 1) {
                    break;
                }
            }

            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());

            answer.append(total).append("\n");
        }

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

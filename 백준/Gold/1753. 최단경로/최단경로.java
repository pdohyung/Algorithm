
import java.util.*;
import java.io.*;

class Node {
    int pos;
    int weight;

    public Node(int pos, int weight) {
        this.pos = pos;
        this.weight = weight;
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(br.readLine());

        ArrayList<Node>[] graph = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph[start].add(new Node(end, weight));
        }

        int[] dist = new int[V + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[S] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[1], o2[1]));
        pq.add(new int[]{S, 0});

        while (!pq.isEmpty()) {
            int[] now = pq.poll();
            int current = now[0];
            int sum = now[1];

            if (dist[current] < sum) continue;

            for (Node next : graph[current]) {
                int pos = next.pos;
                int weight = next.weight;

                if (dist[pos] > dist[current] + weight) {
                    dist[pos] = dist[current] + weight;
                    pq.add(new int[]{pos, dist[pos]});
                }
            }
        }

        for (int i = 1; i <= V; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
            } else {
                System.out.println(dist[i]);
            }
        }
    }
}

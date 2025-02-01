
import java.util.*;
import java.io.*;

class Node {
    int next;
    int cost;

    public Node(int next, int cost) {
        this.next = next;
        this.cost = cost;
    }
}

public class Main {

    static int N, M, start, end;
    static ArrayList<Node>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[start].add(new Node(end, cost));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        System.out.println(dij());
    }

    private static int dij() {
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[1], o2[1]));
        pq.add(new int[]{start, 0});

        while (!pq.isEmpty()) {
            int[] now = pq.poll();
            int current = now[0];
            int cost = now[1];

            if (dist[current] < cost) continue;

            for (Node node : graph[current]) {
                if (dist[node.next] > dist[current] + node.cost) {
                    dist[node.next] = dist[current] + node.cost;
                    pq.add(new int[]{node.next, node.cost});
                }
            }
        }
//        System.out.println(Arrays.toString(dist));
        return dist[end];
    }
}

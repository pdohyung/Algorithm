
import java.util.*;
import java.io.*;

class Node {
    int end, cost;

    public Node(int end, int cost) {
        this.end = end;
        this.cost = cost;
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        ArrayList<Node>[] graph = new ArrayList[N + 1];
        ArrayList<Node>[] reverseGraph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
            reverseGraph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[start].add(new Node(end, cost));
            reverseGraph[end].add(new Node(start, cost));
        }

        // X까지 가는 최소 거리 구하기
        int[] distToX = dijkstra(graph, X, N);

        // X에서 각 마을로 가는 최소 거리 구하기
        int[] distFromX = dijkstra(reverseGraph, X, N);

        int maxDist = Integer.MIN_VALUE;
        for (int i = 1; i <= N; i++) maxDist = Math.max(maxDist, distToX[i] + distFromX[i]);
        System.out.println(maxDist);
    }

    private static int[] dijkstra(List<Node>[] graph, int start, int N) {
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));

        pq.offer(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node now = pq.poll();
            int end = now.end;
            int total = now.cost;

            if (dist[end] < total) continue;

            for (Node next : graph[end]) {
                if (dist[next.end] > total + next.cost) {
                    dist[next.end] = total + next.cost;
                    pq.add(new Node(next.end, total + next.cost));
                }
            }
        }

        return dist;
    }
}

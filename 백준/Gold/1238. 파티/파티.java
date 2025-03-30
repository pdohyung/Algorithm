
import java.util.*;
import java.io.*;

class Node {
    int end, cost;

    public Node(int end, int cost) {
        this.end = end;
        this.cost = cost;
    }
}

class Target {
    int next, total;

    public Target(int next, int total) {
        this.next = next;
        this.total = total;
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

        // 파티가 열리는 마을은 0, 나머지 거리는 최대로 초기화
        int[][] dist = new int[N + 1][2];
        for (int i = 0; i <= N; i++) Arrays.fill(dist[i], Integer.MAX_VALUE);
        Arrays.fill(dist[X], 0);

        // X까지 가는 최소 거리 구하기
        PriorityQueue<Target> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.total, o2.total));
        for (Node n : reverseGraph[X]) pq.add(new Target(n.end, n.cost));

        while (!pq.isEmpty()) {
            Target now = pq.poll();
            int nextPos = now.next;
            int total = now.total;

            if (dist[nextPos][0] < total) continue;
            dist[nextPos][0] = total;

            for (Node next : reverseGraph[nextPos]) {
                pq.add(new Target(next.end, total + next.cost));
            }
        }

        // X에서 각 마을로 가는 최소 거리 구하기
        for (Node n : graph[X]) pq.add(new Target(n.end, n.cost));

        while (!pq.isEmpty()) {
            Target now = pq.poll();
            int nextPos = now.next;
            int total = now.total;

            if (dist[nextPos][1] < total) continue;
            dist[nextPos][1] = total;

            for (Node next : graph[nextPos]) {
                pq.add(new Target(next.end, total + next.cost));
            }
        }

        int maxDist = Integer.MIN_VALUE;
        for (int i = 1; i <= N; i++) maxDist = Math.max(maxDist, dist[i][0] + dist[i][1]);
        System.out.println(maxDist);
    }
}

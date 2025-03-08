
import java.util.*;
import java.io.*;

class Node {
    int pos;
    int cost;

    public Node(int pos, int cost) {
        this.pos = pos;
        this.cost = cost;
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        ArrayList<Node>[] graph = new ArrayList[D + 1];
        for (int i = 0; i <= D; i++) graph[i] = new ArrayList<>();
        for (int i = 0; i < D; i++) graph[i].add(new Node(i + 1, 1));

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            if (e > D) continue;

            graph[s].add(new Node(e, cost));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
        int[] dist = new int[D + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        pq.add(new Node(0, 0));

        while (!pq.isEmpty()) {
            Node now = pq.poll();
            int nowPos = now.pos;
            int nowCost = now.cost;

            if (dist[nowPos] < nowCost) continue;

            for (Node next : graph[nowPos]) {
                int nextPos = next.pos;
                int nextCost = next.cost + nowCost;

                if (nextCost < dist[nextPos]) {
                    dist[nextPos] = nextCost;
                    pq.add(new Node(nextPos, nextCost));
                }
            }
        }
//        System.out.println(Arrays.toString(dist));
        System.out.println(dist[D]);
    }
}

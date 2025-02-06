
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

        ArrayList<Node>[] graph = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph[start].add(new Node(end, weight));
            graph[end].add(new Node(start, weight));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.weight, o2.weight));
        pq.add(new Node(1, 0));
        int cnt = 0;
        int totalWeight = 0;
        boolean[] visited = new boolean[V + 1];

        while (!pq.isEmpty()) {
            Node now = pq.poll();
            int current = now.pos;
            int weight = now.weight;

            if (visited[current]) continue;
            visited[current] = true;
            totalWeight += weight;
            cnt++;

            if (cnt == V) break;

            for (Node next : graph[current]) {
                if (!visited[next.pos]) {
                    pq.add(next);
                }
            }
        }

        System.out.println(totalWeight);
    }
}

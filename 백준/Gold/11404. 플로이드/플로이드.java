
import java.util.*;
import java.io.*;

class Node {
    int next;
    int weight;

    public Node(int next, int weight) {
        this.next = next;
        this.weight = weight;
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        ArrayList<Node>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();
        int m = Integer.parseInt(br.readLine());

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph[start].add(new Node(end, weight));
        }

        StringBuilder answer = new StringBuilder();
        int[] dist = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[i] = 0;

            PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[1], o2[1]));
            pq.add(new int[]{i, 0});

            while (!pq.isEmpty()) {
                int[] now = pq.poll();
                int current = now[0];
                int sum = now[1];

                if (dist[current] < sum) continue;

                for (Node node : graph[current]) {
                    int next = node.next;
                    int weight = node.weight;

                    if (dist[next] > dist[current] + weight) {
                        dist[next] = dist[current] + weight;
                        pq.add(new int[]{next, dist[next]});
                    }
                }
            }

            for (int j = 1; j <= n; j++) {
                if (dist[j] == Integer.MAX_VALUE) {
                    answer.append(0 + " ");
                } else {
                    answer.append(dist[j] + " ");
                }
            }
            answer.append("\n");
        }

        System.out.println(answer);
    }
}

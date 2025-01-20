
import java.util.*;
import java.io.*;

class Node {
    int pos;
    int time;

    public Node(int pos, int time) {
        this.pos = pos;
        this.time = time;
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int max = 100_000;
        int[] dist = new int[max + 1];

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[N] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.time, o2.time));

        pq.add(new Node(N, 0));

        while (!pq.isEmpty()) {
            Node now = pq.poll();
            int time = now.time;
            int pos = now.pos;

            if (dist[pos] < time) continue;

            if (2 * pos <= max && dist[2 * pos] > time) {
                dist[2 * pos] = time;
                pq.add(new Node(2 * pos, time));
            }

            if (pos + 1 <= max && dist[pos + 1] > time + 1) {
                dist[pos + 1] = time + 1;
                pq.add(new Node(pos + 1, time + 1));
            }

            if (pos - 1 >= 0 && dist[pos - 1] > time + 1) {
                dist[pos - 1] = time + 1;
                pq.add(new Node(pos - 1, time + 1));
            }
        }

        System.out.println(dist[K]);
    }
}


import java.util.*;
import java.io.*;

class Node {
    int pos, cnt;

    Node(int pos, int cnt) {
        this.pos = pos;
        this.cnt = cnt;
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.cnt, b.cnt));
        pq.add(new Node(N, 0));
        int[] dist = new int[100_001];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[N] = 0;

        while (!pq.isEmpty()) {
            Node now = pq.poll();
            int pos = now.pos;
            int cnt = now.cnt;

            if (dist[pos] < cnt) continue;

            if (2 * pos <= 100_000 && dist[2 * pos] > dist[pos] + 1) {
                dist[2 * pos] = dist[pos] + 1;
                pq.add(new Node(2 * pos, cnt + 1));
            }

            if (pos - 1 >= 0 && dist[pos - 1] > dist[pos] + 1) {
                dist[pos - 1] = dist[pos] + 1;
                pq.add(new Node(pos - 1, cnt + 1));
            }

            if (pos + 1 <= 100_000 && dist[pos + 1] > dist[pos] + 1) {
                dist[pos + 1] = dist[pos] + 1;
                pq.add(new Node(pos + 1, cnt + 1));
            }
        }

        System.out.println(dist[K]);
    }
}

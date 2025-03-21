
import java.util.*;
import java.io.*;

class Node {
    int pos, cnt;

    public Node(int pos, int cnt) {
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
        int max = Math.max(N, K);

        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cnt, o2.cnt));
        pq.add(new Node(N, 0));

        int[] dist = new int[2 * max + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[N] = 0;

        while (!pq.isEmpty()) {
            Node now = pq.poll();
            int pos = now.pos;
            int cnt = now.cnt;

            if (pos == K) break;
            if (dist[pos] < cnt) continue;

            if (pos + 1 < dist.length && dist[pos + 1] > cnt + 1) {
                dist[pos + 1] = cnt + 1;
                pq.add(new Node(pos + 1, cnt + 1));
            }

            if (pos - 1 >= 0 && dist[pos - 1] > cnt + 1) {
                dist[pos - 1] = cnt + 1;
                pq.add(new Node(pos - 1, cnt + 1));
            }

            if (pos * 2 < dist.length && dist[pos * 2] > cnt + 1) {
                dist[pos * 2] = cnt + 1;
                pq.add(new Node(pos * 2, cnt + 1));
            }
        }

        System.out.println(dist[K]);
    }
}


import java.util.*;
import java.io.*;

class Node {
    int floor;
    int cnt;

    Node(int floor, int cnt) {
        this.floor = floor;
        this.cnt = cnt;
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int F = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());
        int U = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        int[] dist = new int[F + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[S] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cnt, o2.cnt));
        pq.add(new Node(S, 0));

        while (!pq.isEmpty()) {
            Node now = pq.poll();
            int floor = now.floor;
            int cnt = now.cnt;

            int upFloor = floor + U;
            int downFloor = floor - D;

            if (upFloor <= F && dist[upFloor] > cnt + 1) {
                dist[upFloor] = cnt + 1;
                pq.add(new Node(upFloor, cnt + 1));
            }

            if (downFloor > 0 && dist[downFloor] > cnt + 1) {
                dist[downFloor] = cnt + 1;
                pq.add(new Node(downFloor, cnt + 1));
            }
        }

        if (dist[G] == Integer.MAX_VALUE) {
            System.out.println("use the stairs");
            return;
        }
        System.out.println(dist[G]);
    }
}

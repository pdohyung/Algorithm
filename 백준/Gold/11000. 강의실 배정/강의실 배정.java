import java.util.*;
import java.io.*;

class Node {
    int s;
    int t;

    public Node(int s, int t) {
        this.s = s;
        this.t = t;
    }

    public int getS() {
        return s;
    }

    public int getT() {
        return t;
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(Node::getS).thenComparing(Node::getT));

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            pq.add(new Node(s, t));
        }

        Node first = pq.poll();
        PriorityQueue<Integer> end = new PriorityQueue<>();
        end.add(first.t);

        while (!pq.isEmpty()) {
            Node now = pq.poll();
            int s = now.s;
            int t = now.t;

            int before = end.poll();

            if (before <= s) {
                end.add(t);
            } else {
                end.add(before);
                end.add(t);
            }
        }

        System.out.println(end.size());
    }
}

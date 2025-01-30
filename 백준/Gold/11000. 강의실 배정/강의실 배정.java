import java.util.*;
import java.io.*;

class Node {
    int s;
    int t;

    public Node(int s, int t) {
        this.s = s;
        this.t = t;
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.s));

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            pq.add(new Node(s, t));
        }

        PriorityQueue<Integer> end = new PriorityQueue<>();

        while (!pq.isEmpty()) {
            Node now = pq.poll();
            if (!end.isEmpty() && end.peek() <= now.s) {
                end.poll();
            }
            end.add(now.t);
        }

        System.out.println(end.size());
    }
}

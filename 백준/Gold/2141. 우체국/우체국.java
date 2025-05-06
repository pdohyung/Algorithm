
import java.util.*;
import java.io.*;

class Node {
    int x, a;

    public Node(int x, int a) {
        this.x = x;
        this.a = a;
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Node[] nodes = new Node[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            nodes[i] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(nodes, (a, b) -> a.x - b.x);

        long total = 0;
        for (int i = 0; i < N; i++) total += nodes[i].a;

        long now = 0;
        for (int i = 0; i < N; i++) {
            now += nodes[i].a;

            if (now * 2 >= total) {
                System.out.println(nodes[i].x);
                return;
            }
        }
    }
}

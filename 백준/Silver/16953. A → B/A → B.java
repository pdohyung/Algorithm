import java.util.*;
import java.io.*;

class Node {
    long num;
    long cnt;

    public Node(long num, long cnt) {
        this.num = num;
        this.cnt = cnt;
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Integer.parseInt(st.nextToken());
        long B = Integer.parseInt(st.nextToken());

        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node(A, 1));

        while (!q.isEmpty()) {
            Node now = q.poll();
            long num = now.num;
            long cnt = now.cnt;

            if (num == B) {
                System.out.println(cnt);
                return;
            }

            if (num * 2 <= B) {
                q.add(new Node(num * 2, cnt + 1));
            }

            if (num * 10 + 1 <= B) {
                q.add(new Node(num * 10 + 1, cnt + 1));
            }
        }

        System.out.println(-1);
    }
}

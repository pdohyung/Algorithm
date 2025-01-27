
import java.util.*;
import java.io.*;

class Node {
    int next;
    int cnt;

    public Node(int next, int cnt) {
        this.next = next;
        this.cnt = cnt;
    }
}

public class Main {

    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        result = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            graph[s].add(e);
            graph[e].add(s);
        }

        int min = Integer.MAX_VALUE;

        for (int i = 1; i <= N; i++) {
            visited = new boolean[N + 1];
            result[i] = bfs(new Node(i, 0));
            min = Math.min(min, result[i]);
//            System.out.println(result[i]);
        }

        for (int i = 1; i <= N; i++) {
            if (min == result[i]) {
                System.out.println(i);
                break;
            }
        }
    }

    private static int bfs(Node start) {
        ArrayDeque<Node> q = new ArrayDeque<>();
        q.add(start);
        visited[start.next] = true;
        int total = 0;

        while (!q.isEmpty()) {
            Node now = q.poll();
            int nextPos = now.next;
            int cnt = now.cnt;

            for (int next : graph[nextPos]) {
                if (visited[next]) continue;

                visited[next] = true;
                total += cnt + 1;
                q.add(new Node(next, cnt + 1));
            }
        }
//        System.out.println(total);
        return total;
    }
}

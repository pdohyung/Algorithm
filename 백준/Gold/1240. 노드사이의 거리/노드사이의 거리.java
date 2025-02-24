
import java.util.*;
import java.io.*;

class Node {
    int pos;
    int dis;

    public Node(int pos, int dis) {
        this.pos = pos;
        this.dis = dis;
    }
}

public class Main {

    static ArrayList<Node>[] graph;
    static int N, M, start, end;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            graph[s].add(new Node(e, d));
            graph[e].add(new Node(s, d));
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            System.out.println(bfs(start));
        }
    }

    private static int bfs(int start) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{start, 0});

        boolean[] visited = new boolean[N + 1];
        visited[start] = true;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int current = now[0];
            int sum = now[1];

            if (current == end) return sum;

            for (Node next : graph[current]) {
                if (visited[next.pos]) continue;
                visited[next.pos] = true;
                q.add(new int[]{next.pos, sum + next.dis});
            }
        }

        return -1;
    }
}

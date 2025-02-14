import java.util.*;
import java.io.*;

class Node {
    int pos;
    int cnt;

    public Node(int pos, int cnt) {
        this.pos = pos;
        this.cnt = cnt;
    }
}

public class Main {

    static int N, c, min;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        while (start != -1 && end != -1) {
            graph[start].add(end);
            graph[end].add(start);

            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
        }

        result = new int[N + 1];
        min = Integer.MAX_VALUE;

        for (int i = 1; i <= N; i++) {
            c = 0;
            visited = new boolean[N + 1];
            bfs(new Node(i, 0));
            result[i] = c;
            min = Math.min(min, result[i]);
        }

        int total = 0;
        StringBuilder answer = new StringBuilder();

        for (int i = 1; i <= N; i++) {
            if (result[i] == min) {
                total++;
                answer.append(i).append(" ");
            }
        }

        System.out.println(min + " " + total);
        System.out.println(answer);
    }

    private static void bfs(Node start) {
        Queue<Node> q = new ArrayDeque<>();
        q.add(start);
        visited[start.pos] = true;

        while (!q.isEmpty()) {
            Node now = q.poll();
            int pos = now.pos;
            int cnt = now.cnt;

            for (int next : graph[pos]) {
                if (visited[next]) continue;

                visited[next] = true;
                q.add(new Node(next, cnt + 1));
                c = cnt + 1;
            }
        }
    }
}

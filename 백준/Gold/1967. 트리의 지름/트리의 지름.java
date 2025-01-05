
import java.io.*;
import java.util.*;

class Node {
    int to;
    int cost;

    Node(int to, int cost) {
        this.to = to;
        this.cost = cost;
    }
}

public class Main {

    static ArrayList<Node>[] graph;
    static int n, answer, last;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        if (n == 1) {
            System.out.println(0);
            return;
        }

        graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[start].add(new Node(end, cost));
            graph[end].add(new Node(start, cost));
        }

        visited = new boolean[n + 1];
        dfs(1, 0);

        visited = new boolean[n + 1];
        dfs(last, 0);

        System.out.println(answer);
    }

    private static void dfs(int start, int sum) {
        visited[start] = true;

        if (sum > answer) {
            answer = sum;
            last = start;
        }

        for (Node next : graph[start]) {
            if (!visited[next.to]) {
                dfs(next.to, sum + next.cost);
            }
        }
    }
}

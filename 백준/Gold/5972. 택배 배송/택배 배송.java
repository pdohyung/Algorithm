
import java.util.*;
import java.io.*;

class Node {
    int end, cost;

    public Node(int end, int cost) {
        this.end = end;
        this.cost = cost;
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<Node>[] graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[start].add(new Node(end, cost));
            graph[end].add(new Node(start, cost));
        }

        int[] totalCost = new int[N + 1];
        Arrays.fill(totalCost, Integer.MAX_VALUE);
        totalCost[1] = 0;

        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node(1, 0));

        while (!q.isEmpty()) {
            Node now = q.poll();
            int end = now.end;
            int cost = now.cost;

            if (totalCost[end] < cost) continue;

            for (Node next : graph[end]) {
                if (totalCost[next.end] > cost + next.cost) {
                    totalCost[next.end] = cost + next.cost;
                    q.add(new Node(next.end, cost + next.cost));
                }
            }
        }
        
        System.out.println(totalCost[N]);
    }
}


import java.io.*;
import java.util.*;

class Node {
    int now;
    long cost;

    public Node(int now, long cost) {
        this.now = now;
        this.cost = cost;
    }
}

public class Main {

    static List<Integer>[] graph;
    static int N, M, K, S, P, Q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        P = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        // 좀비에게 점령당한 도시
        List<Integer> zCities = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            zCities.add(Integer.parseInt(br.readLine()));
        }

        // 도시 그래프
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            graph[s].add(e);
            graph[e].add(s);
        }

        // 1. 위험도시 기록
        long[] distFromZombie = new long[N + 1];
        Arrays.fill(distFromZombie, -1);
        Queue<Integer> q = new LinkedList<>();

        for (int z : zCities) {
            q.add(z);
            distFromZombie[z] = 0;
        }

        while (!q.isEmpty()) {
            int now = q.poll();
            if (distFromZombie[now] >= S) continue;

            for (int next : graph[now]) {
                if (distFromZombie[next] == -1) {
                    distFromZombie[next] = distFromZombie[now] + 1;
                    q.add(next);
                }
            }
        }

//        System.out.println(Arrays.toString(distFromZombie));

        // 2. N 도시로 이동
        // 점령된 도시 불가, 위험도시면 숙박비 q (기록된 값이 S보다 크면 q 아니면 p)
        // 다익스트라, 비용이 적은 순서로 처리, N에 도착하면 종료, 현재 cost보다 크면 pass

        long[] result = new long[N + 1];
        Arrays.fill(result, Long.MAX_VALUE);
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> Long.compare(a.cost, b.cost));
        pq.offer(new Node(1, 0));
        result[1] = 0;


        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int now = node.now;
            long cost = node.cost;

            if (cost > result[now]) continue;

            for (int next : graph[now]) {
                if (distFromZombie[next] == 0) continue;

                long nextCost = (next == N) ? 0 : (distFromZombie[next] != -1 ? Q : P);

                if (cost + nextCost < result[next]) {
                    result[next] = cost + nextCost;
                    pq.offer(new Node(next, result[next]));
                }
            }
        }

        System.out.println(result[N]);
    }
}

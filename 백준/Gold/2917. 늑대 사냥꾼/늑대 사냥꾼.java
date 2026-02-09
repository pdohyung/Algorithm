import java.io.*;
import java.util.*;

class Node {
    int x;
    int y;
    int d;

    Node(int x, int y, int d) {
        this.x = x;
        this.y = y;
        this.d = d;
    }
}

public class Main {

    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {-1, 0, 1, 0};
    static char[][] map;
    static List<Node> trees;
    static int N, M;
    static Node start, end;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        trees = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                char now = line.charAt(j);
                map[i][j] = now;

                if (now == 'V') start = new Node(i, j, 0);
                else if (now == 'J') end = new Node(i, j, 0);
                else if (now == '+') trees.add(new Node(i, j, 0));
            }
        }

        int[][] dist = new int[N][M];
        for (int i = 0; i < N; i++) {
            Arrays.fill(dist[i], -1);
        }
        Queue<Node> q = new LinkedList<>();
        for (Node now : trees) {
            dist[now.x][now.y] = 0;
            q.offer(now);
        }

        while (!q.isEmpty()) {
            Node now = q.poll();
            int x = now.x;
            int y = now.y;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || nx >= N || ny < 0 || ny >= M || dist[nx][ny] != -1) continue;
                dist[nx][ny] = dist[x][y] + 1;
                q.offer(new Node(nx, ny, dist[nx][ny]));
            }
        }

        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> b.d - a.d);
        start.d = dist[start.x][start.y];
        pq.offer(start);
        boolean[][] visited = new boolean[N][M];
        visited[start.x][start.y] = true;
        int minDist = Integer.MAX_VALUE;

        while (!pq.isEmpty()) {
            Node now = pq.poll();
            int x = now.x;
            int y = now.y;
            int d = now.d;

            minDist = Math.min(minDist, d);

            if (now.x == end.x && now.y == end.y) {
                System.out.println(minDist);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny]) continue;

                visited[nx][ny] = true;
                pq.offer(new Node(nx, ny, dist[nx][ny]));
            }
        }
    }
}


import java.util.*;
import java.io.*;

class Node {
    int x;
    int y;
    int sum;

    public Node(int x, int y, int sum) {
        this.x = x;
        this.y = y;
        this.sum = sum;
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];
        int[][] dist = new int[N][N];
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int cnt = 0;

        while (N != 0) {
            cnt++;

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < N; i++) Arrays.fill(dist[i], Integer.MAX_VALUE);
            dist[0][0] = map[0][0];

            PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.sum, o2.sum));
            pq.add(new Node(0, 0, dist[0][0]));

            while (!pq.isEmpty()) {
                Node now = pq.poll();
                int x = now.x;
                int y = now.y;
                int sum = now.sum;

                if (dist[x][y] < sum) continue;

                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;

                    if (dist[nx][ny] > dist[x][y] + map[nx][ny]) {
                        dist[nx][ny] = dist[x][y] + map[nx][ny];
                        pq.add(new Node(nx, ny, dist[nx][ny]));
                    }
                }
            }

            System.out.println("Problem " + cnt + ": " + dist[N - 1][N - 1]);

            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            dist = new int[N][N];
        }
    }
}

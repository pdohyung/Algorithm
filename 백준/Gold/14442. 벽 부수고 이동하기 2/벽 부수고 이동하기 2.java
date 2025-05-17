
import java.util.*;
import java.io.*;

class Node {
    int x, y, w;

    public Node(int x, int y, int w) {
        this.x = x;
        this.y = y;
        this.w = w;
    }
}

public class Main {

    static int N, M, K;
    static int[][] map;
    static int[][][] dist;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        dist = new int[N][M][K + 1];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                int now = Character.getNumericValue(line.charAt(j));
                if (now == 1) now = -1;
                map[i][j] = now;
            }
        }

        bfs(new Node(0, 0, 0));

        // 디버깅용 출력
//        for (int k = 0; k <= K; k++) {
//            for (int i = 0; i < N; i++) {
//                for (int j = 0; j < M; j++) {
//                    System.out.print(dist[i][j][k] + " ");
//                }
//                System.out.println();
//            }
//            System.out.println();
//        }

        int answer = Integer.MAX_VALUE;

        for (int k = 0; k <= K; k++) {
            if (dist[N - 1][M - 1][k] == 0) continue;
            answer = Math.min(answer, dist[N - 1][M - 1][k]);
        }

        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }

    static void bfs(Node start) {
        Queue<Node> q = new LinkedList<>();
        q.offer(start);
        dist[start.x][start.y][start.w] = 1;

        while (!q.isEmpty()) {
            Node now = q.poll();
            int x = now.x;
            int y = now.y;
            int w = now.w;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                if (map[nx][ny] == -1 && w == K) continue;

                if (map[nx][ny] == -1 && dist[nx][ny][w + 1] == 0) {
                    dist[nx][ny][w + 1] = dist[x][y][w] + 1;
                    q.offer(new Node(nx, ny, w + 1));
                }

                if (map[nx][ny] == 0 && dist[nx][ny][w] == 0) {
                    dist[nx][ny][w] = dist[x][y][w] + 1;
                    q.offer(new Node(nx, ny, w));
                }
            }
        }
    }
}

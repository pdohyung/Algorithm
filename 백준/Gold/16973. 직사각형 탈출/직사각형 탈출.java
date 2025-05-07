
import java.util.*;
import java.io.*;

class Node {
    int x, y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {

    static int N, M, H, W;
    static int[][] map, sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N + 1][M + 1];
        sum = new int[N + 1][M + 1];
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                int v = Integer.parseInt(st.nextToken());
                if (v == 1) v = -1;
                map[i][j] = v;
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                sum[i][j] = (map[i][j] == -1 ? 1 : 0) + sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1];
            }
        }

        st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        Node start = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        Node end = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

        map[start.x][start.y] = 1;
        Queue<Node> q = new ArrayDeque<>();
        q.offer(start);

        while (!q.isEmpty()) {
            Node now = q.poll();
            int x = now.x;
            int y = now.y;

            if (end.x == x && end.y == y) break;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (!isValid(nx, ny) || map[nx][ny] != 0) continue;

                map[nx][ny] = map[x][y] + 1;
                q.offer(new Node(nx, ny));
            }
        }

        int result = map[end.x][end.y];

        if (result <= 0) System.out.println(-1);
        else System.out.println(result - 1);
    }

    static boolean isValid(int nx, int ny) {
        int tx = nx + H - 1;
        int ty = ny + W - 1;

        if (nx < 1 || nx > N || ny < 1 || ny > M) return false;
        if (tx < 1 || tx > N || ty < 1 || ty > M) return false;

        int result = sum[tx][ty] - sum[nx - 1][ty] - sum[tx][ny - 1] + sum[nx - 1][ny - 1];

        return result == 0;
    }
}

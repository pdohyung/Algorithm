import java.io.*;
import java.util.*;

/**
 * 6 4
 * 0 0 0 0 0 0
 * 0 0 0 0 0 0
 * 0 0 0 0 0 0
 * 0 0 0 0 0 1
 */

class Node {
    int x;
    int y;

    Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    int getX() {
        return x;
    }

    int getY() {
        return y;
    }
}

public class Main {

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    static BufferedReader br;
    static StringTokenizer st;
    static int[][] map;
    static boolean[][] visit;
    static ArrayDeque<Node> q;
    static int N, M;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[M][N];
        visit = new boolean[M][N];
        q = new ArrayDeque<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int condition = Integer.parseInt(st.nextToken());
                map[i][j] = condition;
                if (condition == 1) {
                    q.add(new Node(i, j));
                }
            }
        }

        bfs();
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                int condition = map[i][j];
                if (condition == 0) {
                    System.out.println(-1);
                    return;
                }
                max = Math.max(max, condition);
            }
        }

        System.out.println(max - 1);
    }

    static void bfs() {
        while (!q.isEmpty()) {
            Node now = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now.getX() + dx[i];
                int ny = now.getY() + dy[i];

                if (ny >= N || ny < 0 || nx >= M || nx < 0) continue;
                if (map[nx][ny] != 0 || visit[nx][ny]) continue;

                map[nx][ny] = map[now.getX()][now.getY()] + 1;
                visit[nx][ny] = true;
                q.add(new Node(nx, ny));
            }
        }
    }
}

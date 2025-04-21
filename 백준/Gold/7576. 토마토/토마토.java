
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

    static int N, M;
    static int[][] map;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static List<Node> tomato;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        int cnt = 0;
        tomato = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int now = Integer.parseInt(st.nextToken());

                if (now == 1) {
                    tomato.add(new Node(i, j));
                } else if (now == 0) cnt++;

                map[i][j] = now;
            }
        }

        if (cnt == 0) {
            System.out.println(0);
            return;
        }

        bfs();

        int answer = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }

                answer = Math.max(answer, map[i][j]);
            }
        }

        System.out.println(answer - 1);
    }

    static void bfs() {
        Queue<Node> q = new ArrayDeque<>(tomato);

        while (!q.isEmpty()) {
            Node now = q.poll();
            int x = now.x;
            int y = now.y;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M || map[nx][ny] != 0) continue;

                map[nx][ny] = map[x][y] + 1;
                q.add(new Node(nx, ny));
            }
        }
    }
}

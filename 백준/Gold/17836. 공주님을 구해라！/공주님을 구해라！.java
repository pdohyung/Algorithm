import java.util.*;
import java.io.*;

class Node {
    int x, y, s;

    public Node(int x, int y, int s) {
        this.x = x;
        this.y = y;
        this.s = s;
    }
}

public class Main {

    static int N, M, T;
    static int[][][] map;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        map = new int[N][M][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int n = Integer.parseInt(st.nextToken());
                if (n > 0) n *= -1;
                map[i][j][0] = n;
            }
        }

        bfs(new Node(0, 0, 0));

        int result1 = map[N - 1][M - 1][0];
        int result2 = map[N - 1][M - 1][1];
        int answer = 0;

        if (result1 == 0 && result2 == 0) {
            System.out.println("Fail");
            return;
        } else {
            if (result1 == 0) answer = result2;
            else if (result2 == 0) answer = result1;
            else answer = Math.min(map[N - 1][M - 1][0], map[N - 1][M - 1][1]);
        }

        if (answer > T) System.out.println("Fail");
        else System.out.println(answer);
    }


    static void bfs(Node start) {
        Queue<Node> q = new ArrayDeque<>();
        q.offer(start);

        while (!q.isEmpty()) {
            Node now = q.poll();
            int x = now.x;
            int y = now.y;
            int s = now.s;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                if (map[nx][ny][s] == -1 || map[nx][ny][s] > 0) continue;

                if (map[nx][ny][s] == -2) {
                    map[nx][ny][0] = map[nx][ny][1] = map[x][y][s] + 1;
                    q.add(new Node(nx, ny, 1));
                    q.add(new Node(nx, ny, 0));
                } else {
                    map[nx][ny][s] = map[x][y][s] + 1;
                    q.add(new Node(nx, ny, s));
                }
            }
        }
    }
}

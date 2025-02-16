
import java.util.*;
import java.io.*;

class Node {
    int x;
    int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {

    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, -1, -1, -1, 0, 1, 1, 1};
    static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;

        for (int i = 0; i < M; i++) {
            Queue<Node> q = new ArrayDeque<>();
            if (i == 0) {
                for (int x = N - 2; x < N; x++) {
                    for (int y = 0; y < 2; y++) {
                        q.add(new Node(x, y));
                    }
                }
            } else {
                for (int x = 0; x < N; x++) {
                    for (int y = 0; y < N; y++) {
                        if (visited[x][y]) {
                            visited[x][y] = false;
                            continue;
                        }

                        if (map[x][y] > 1) {
                            map[x][y] -= 2;
                            q.add(new Node(x, y));
                        }
                    }
                }
            }

            st = new StringTokenizer(br.readLine());
            int dir = Integer.parseInt(st.nextToken());
            int cnt = Integer.parseInt(st.nextToken());

            bfs(q, dir - 1, cnt);

            if (i == M - 1) {
                for (int x = 0; x < N; x++) {
                    for (int y = 0; y < N; y++) {
                        if (visited[x][y]) {
                            answer += map[x][y];
                            continue;
                        }
                        if (map[x][y] > 1) map[x][y] -= 2;
                        answer += map[x][y];
                    }
                }
            }
        }

        System.out.println(answer);
    }

    private static void bfs(Queue<Node> q, int dir, int cnt) {
        // 이동
        for (int i = 0; i < q.size(); i++) {
            Node now = q.poll();
            int x = now.x;
            int y = now.y;

            int nx = (x + cnt * dx[dir]) % N;
            int ny = (y + cnt * dy[dir]) % N;

            if (nx < 0) nx += N;
            if (ny < 0) ny += N;

            visited[nx][ny] = true;
            map[nx][ny]++;

            q.add(new Node(nx, ny));
        }

        // 대각선 검사 후 갱신
        for (int i = 0; i < q.size(); i++) {
            Node now = q.poll();
            int x = now.x;
            int y = now.y;
            int sum = 0;

            for (int j = 1; j < 8; j += 2) {
                int nx = x + dx[j];
                int ny = y + dy[j];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N || map[nx][ny] == 0) continue;

                sum++;
            }

            map[x][y] += sum;

            q.add(now);
        }
    }
}

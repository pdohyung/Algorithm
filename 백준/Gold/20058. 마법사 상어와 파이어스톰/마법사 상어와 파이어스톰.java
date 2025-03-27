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

    static int N, Q, L;
    static int[][] map, newMap;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = (int) Math.pow(2, Integer.parseInt(st.nextToken()));
        Q = Integer.parseInt(st.nextToken());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) map[i][j] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int q = 0; q < Q; q++) {
            L = Integer.parseInt(st.nextToken());
            L = (int) Math.pow(2, L);
            // 격자 회전
            newMap = new int[N][N];
            rotateAll();
            // 회전 결과 반영
            for (int i = 0; i < N; i++) map[i] = newMap[i].clone();
            // 얼음 녹이기
            update();
        }

        int sum = 0;
        int max = 0;
        boolean[][] visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sum += map[i][j];
                if (visited[i][j] || map[i][j] == 0) continue;
                max = Math.max(max, bfs(new Node(i, j), visited));
            }
        }

        System.out.println(sum);
        System.out.println(max);
    }

    private static int bfs(Node start, boolean[][] visited) {
        Queue<Node> q = new ArrayDeque<>();
        q.add(start);
        visited[start.x][start.y] = true;
        int size = 1;

        while (!q.isEmpty()) {
            Node now = q.poll();
            int x = now.x;
            int y = now.y;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                if (map[nx][ny] == 0 || visited[nx][ny]) continue;

                visited[nx][ny] = true;
                q.add(new Node(nx, ny));
                size++;
            }
        }

        return size;
    }

    private static void update() {
        List<Node> decrease = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 0) continue;
                int cnt = 0;
                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];

                    if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                    if (map[nx][ny] > 0) cnt++;
                }
                if (cnt < 3) decrease.add(new Node(i, j));
            }
        }

        for (Node d : decrease) map[d.x][d.y]--;
    }

    private static void rotateAll() {
        for (int x = 0; x < N; x += L) {
            for (int y = 0; y < N; y += L) {
                for (int i = 0; i < L; i++) {
                    for (int j = 0; j < L; j++) {
                        newMap[x + j][y + L - i - 1] = map[x + i][y + j];
                    }
                }
            }
        }
    }
}

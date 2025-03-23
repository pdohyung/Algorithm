
import java.util.*;
import java.io.*;

class Node {
    int x, y, val;

    public Node(int x, int y, int val) {
        this.x = x;
        this.y = y;
        this.val = val;
    }
}

public class Main {

    static int R, C, T;
    static int[][] room;
    static List<Node> pos;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        room = new int[R][C];
        pos = new ArrayList<>();

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                int now = Integer.parseInt(st.nextToken());
                if (now == -1) pos.add(new Node(i, j, -1));
                room[i][j] = now;
            }
        }

        for (int t = 0; t < T; t++) {
            // 미세먼지 확산
            Queue<Node> q = new ArrayDeque<>();
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (room[i][j] > 0) q.add(new Node(i, j, room[i][j]));
                }
            }
            bfs(q);
            // 공기정청기 동작
            run();
        }

        // 총 미세먼지
        int answer = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (room[i][j] == -1) continue;
                answer += room[i][j];
            }
        }
        System.out.println(answer);
    }

    private static void bfs(Queue<Node> q) {
        while (!q.isEmpty()) {
            Node now = q.poll();
            int x = now.x;
            int y = now.y;
            int each = now.val / 5;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= R || ny < 0 || ny >= C || room[nx][ny] == -1) continue;

                room[nx][ny] += each;
                room[x][y] -= each;
            }
        }
    }

    private static void run() {
        Node first = pos.get(0);
        Node second = pos.get(1);
        int fx = first.x;
        int fy = first.y;
        int sx = second.x;
        int sy = second.y;

        room[fx - 1][fy] = 0;
        for (int i = fx - 2; i >= 0; i--) room[i + 1][0] = room[i][0];
        for (int i = 1; i < C; i++) room[0][i - 1] = room[0][i];
        for (int i = 1; i <= fx; i++) room[i - 1][C - 1] = room[i][C - 1];
        for (int i = C - 2; i > 0; i--) room[fx][i + 1] = room[fx][i];
        room[fx][fy + 1] = 0;

        room[sx + 1][sy] = 0;
        for (int i = sx + 2; i < R; i++) room[i - 1][0] = room[i][0];
        for (int i = 1; i < C; i++) room[R - 1][i - 1] = room[R - 1][i];
        for (int i = R - 2; i >= sx; i--) room[i + 1][C - 1] = room[i][C - 1];
        for (int i = C - 2; i > 0; i--) room[sx][i + 1] = room[sx][i];
        room[sx][sy + 1] = 0;
    }
}

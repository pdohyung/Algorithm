
import java.util.*;
import java.io.*;

class Node {
    int rx, ry, bx, by, d;

    public Node(int rx, int ry, int bx, int by, int d) {
        this.rx = rx;
        this.ry = ry;
        this.bx = bx;
        this.by = by;
        this.d = d;
    }
}

class MoveInfo {
    int x, y, count;
    boolean isEnd;

    public MoveInfo(int x, int y, int count, boolean isEnd) {
        this.x = x;
        this.y = y;
        this.count = count;
        this.isEnd = isEnd;
    }
}

public class Main {

    static int N, M, answer;
    static char[][] board;
    static int[] R, B;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new char[N][M];
        R = new int[2];
        B = new int[2];

        for (int i = 0; i < N; i++) {
            char[] line = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                if (line[j] == 'R') {
                    R[0] = i;
                    R[1] = j;
                } else if (line[j] == 'B') {
                    B[0] = i;
                    B[1] = j;
                }
                board[i][j] = line[j];
            }
        }

        answer = Integer.MAX_VALUE;
        bfs();
        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }

    private static void bfs() {
        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node(R[0], R[1], B[0], B[1], 0));
        boolean[][][][] visited = new boolean[N][M][N][M];
        visited[R[0]][R[1]][B[0]][B[1]] = true;

        while (!q.isEmpty()) {
            Node now = q.poll();
            int rx = now.rx;
            int ry = now.ry;
            int bx = now.bx;
            int by = now.by;
            int depth = now.d;

            if (depth >= 10) continue;

            for (int i = 0; i < 4; i++) {
                MoveInfo rMove = move(rx, ry, dx[i], dy[i]);
                MoveInfo bMove = move(bx, by, dx[i], dy[i]);

                if (bMove.isEnd) continue;

                if (rMove.isEnd) {
                    answer = depth + 1;
                    return;
                }

                if (rMove.x == bMove.x && rMove.y == bMove.y) {
                    if (rMove.count > bMove.count) {
                        rMove.x -= dx[i];
                        rMove.y -= dy[i];
                    } else {
                        bMove.x -= dx[i];
                        bMove.y -= dy[i];
                    }
                }

                if (!visited[rMove.x][rMove.y][bMove.x][bMove.y]) {
                    visited[rMove.x][rMove.y][bMove.x][bMove.y] = true;
                    q.add(new Node(rMove.x, rMove.y, bMove.x, bMove.y, depth + 1));
                }
            }
        }
    }

    private static MoveInfo move(int x, int y, int dx, int dy) {
        int count = 0;
        boolean isEnd = false;

        while (true) {
            int nx = x + dx;
            int ny = y + dy;

            if (board[nx][ny] == '#') break;

            x = nx;
            y = ny;
            count++;

            if (board[x][y] == 'O') {
                isEnd = true;
                break;
            }
        }

        return new MoveInfo(x, y, count, isEnd);
    }
}

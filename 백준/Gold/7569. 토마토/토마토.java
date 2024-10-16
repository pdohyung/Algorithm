import java.io.*;
import java.util.*;

/**
 * 5 3 2
 * 0 0 0 0 0
 * 0 0 0 0 0
 * 0 0 0 0 0
 * 0 0 0 0 0
 * 0 0 1 0 0
 * 0 0 0 0 0
 */

class Node {
    int x;
    int y;
    int z;

    Node(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    int getX() {
        return x;
    }

    int getY() {
        return y;
    }

    int getZ() {
        return z;
    }
}

public class Main {

    static int[] dx = {0, 1, 0, -1, 0, 0};
    static int[] dy = {1, 0, -1, 0, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};

    static BufferedReader br;
    static StringTokenizer st;
    static int[][][] map;
    static boolean[][][] visit;
    static ArrayDeque<Node> q;
    static int M, N, H;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        map = new int[M][N][H];
        visit = new boolean[M][N][H];
        q = new ArrayDeque<>();


        for (int k = 0; k < H; k++) {
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    int condition = Integer.parseInt(st.nextToken());
                    map[i][j][k] = condition;
                    if (condition == 1) {
                        q.add(new Node(i, j, k));
                    }
                }
            }
        }

//        for (int k = 0; k < H; k++) {
//            for (int i = 0; i < M; i++) {
//                for (int j = 0; j < N; j++) {
//                    System.out.print(map[i][j][k] + " ");
//                }
//                System.out.println();
//            }
//        }

        bfs();
        int max = Integer.MIN_VALUE;

//        for (int k = 0; k < H; k++) {
//            for (int i = 0; i < M; i++) {
//                for (int j = 0; j < N; j++) {
//                    System.out.print(map[i][j][k] + " ");
//                }
//                System.out.println();
//            }
//        }

        for (int k = 0; k < H; k++) {
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    int condition = map[i][j][k];
                    if (condition == 0) {
                        System.out.println(-1);
                        return;
                    }
                    max = Math.max(max, condition);
                }
            }
        }

        System.out.println(max - 1);
    }

    static void bfs() {
        while (!q.isEmpty()) {
            Node now = q.poll();
            for (int i = 0; i < 6; i++) {
                int nx = now.getX() + dx[i];
                int ny = now.getY() + dy[i];
                int nz = now.getZ() + dz[i];

                if (ny >= N || ny < 0 || nx >= M || nx < 0 || nz >= H || nz < 0) continue;
                if (map[nx][ny][nz] != 0 || visit[nx][ny][nz]) continue;

                map[nx][ny][nz] = map[now.getX()][now.getY()][now.getZ()] + 1;
                visit[nx][ny][nz] = true;
                q.add(new Node(nx, ny, nz));
            }
        }
    }
}

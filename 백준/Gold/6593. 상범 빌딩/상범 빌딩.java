import java.util.*;
import java.io.*;

class Node {
    int z, x, y;

    public Node(int z, int x, int y) {
        this.z = z;
        this.x = x;
        this.y = y;
    }
}

public class Main {

    static int L, R, C;
    static Node S, E;
    static int[][][] map;
    static int[] dz = {-1, 1, 0, 0, 0, 0};
    static int[] dx = {0, 0, -1, 1, 0, 0};
    static int[] dy = {0, 0, 0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            if (L == 0 && R == 0 && C == 0) break;

            map = new int[L][R][C];

            for (int l = 0; l < L; l++) {
                for (int r = 0; r < R; r++) {
                    char[] line = br.readLine().toCharArray();
                    for (int c = 0; c < C; c++) {
                        if (line[c] == 'S') S = new Node(l, r, c);
                        else if (line[c] == 'E') E = new Node(l, r, c);
                        else if (line[c] == '#') {
                            map[l][r][c] = -1;
                            continue;
                        }
                        map[l][r][c] = 0;
                    }
                }
                // 빈줄 pass
                br.readLine();
            }

//            //출력문
//            for (int l = 0; l < L; l++) {
//                for (int r = 0; r < R; r++) {
//                    System.out.println(Arrays.toString(map[l][r]));
//                }
//                System.out.println();
//            }

            bfs();

            int answer = map[E.z][E.x][E.y];
            if (answer == 0) System.out.println("Trapped!");
            else System.out.println("Escaped in " + (answer - 1) + " minute(s).");
        }
    }

    private static void bfs() {
        Queue<Node> q = new ArrayDeque<>();
        q.add(S);
        map[S.z][S.x][S.y] = 1;

        while (!q.isEmpty()) {
            Node now = q.poll();
            int z = now.z;
            int x = now.x;
            int y = now.y;

            for (int i = 0; i < 6; i++) {
                int nz = z + dz[i];
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nz < 0 || nz >= L || nx < 0 || nx >= R || ny < 0 || ny >= C || map[nz][nx][ny] != 0) continue;

                q.add(new Node(nz, nx, ny));
                map[nz][nx][ny] = map[z][x][y] + 1;
            }
        }
    }
}

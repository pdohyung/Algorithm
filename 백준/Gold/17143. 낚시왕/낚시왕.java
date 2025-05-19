
import java.util.*;
import java.io.*;

class Shark {
    int r, c, speed, dir, size;

    public Shark(int r, int c, int speed, int dir, int size) {
        this.r = r;
        this.c = c;
        this.speed = speed;
        this.dir = dir;
        this.size = size;
    }
}

public class Main {

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        // 낚시왕이 한칸 이동하여 땅에서 가장 가까운 상어를 잡음
        // 그리고 상어가 움직인다, 상어는 주어진 속도/초 만큼 이동하고 이동하려는 칸이 경계라면, 방향을 바꿔서 이동 (1, 2), (3, 4)
        // 상어가 이동을 마치고, 한 칸에 두 마리 이상 있으면 가장 큰 상어가 모든 상어를 잡아먹음
        // 낚시왕이 잡은 상어 크기의 합을 출력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Shark[][] map = new Shark[R + 1][C + 1];

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            if (d == 1) d = 0;
            else if (d == 4) d = 1;

            map[r][c] = new Shark(r, c, s, d, z);
        }

        int result = 0;

        // 낚시왕 이동하면서 상어 잡기
        for (int i = 1; i <= C; i++) {

            for (int j = 1; j <= R; j++) {
                if (map[j][i] != null) {
                    result += map[j][i].size;
                    map[j][i] = null;
                    break;
                }
            }

            Queue<Shark> sharks = new LinkedList<>();

            for (int x = 1; x <= R; x++) {
                for (int y = 1; y <= C; y++) {
                    if (map[x][y] != null) {
                        sharks.offer(map[x][y]);
                    }
                }
            }

            map = new Shark[R + 1][C + 1];

            while (!sharks.isEmpty()) {
                Shark s = sharks.poll();
                int dist = s.speed;

                if (s.dir == 0 || s.dir == 2) {
                    dist %= (R - 1) * 2;
                } else {
                    dist %= (C - 1) * 2;
                }

                for (int j = 0; j < dist; j++) {
                    int nx = s.r + dx[s.dir];
                    int ny = s.c + dy[s.dir];

                    if (nx < 1 || nx > R || ny < 1 || ny > C) {
                        s.r -= dx[s.dir];
                        s.c -= dy[s.dir];
                        s.dir = (s.dir + 2) % 4;
                        continue;
                    }

                    s.r = nx;
                    s.c = ny;
                }

                if (map[s.r][s.c] != null) {
                    if (s.size > map[s.r][s.c].size) {
                        map[s.r][s.c] = s;
                    }
                } else {
                    map[s.r][s.c] = s;
                }
            }
        }

        System.out.println(result);
    }
}


import java.util.*;
import java.io.*;

class Shark {
    int idx, r, c, speed, dir, size, cnt;

    public Shark(int idx, int r, int c, int speed, int dir, int size, int cnt) {
        this.idx = idx;
        this.r = r;
        this.c = c;
        this.speed = speed;
        this.dir = dir;
        this.size = size;
        this.cnt = cnt;
    }
}

public class Main {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

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
        int[][] map = new int[R + 1][C + 1];

        Map<Integer, Shark> sharks = new HashMap<>();
        List<Shark> now = new ArrayList<>();

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            Shark shark = new Shark(i, r, c, s, d - 1, z, 0);
            sharks.put(i, shark);
            now.add(shark);
            map[r][c] = i;
        }

        int result = 0;

        // 낚시왕 이동하면서 상어 잡기
        for (int i = 1; i <= C; i++) {
            for (int j = 1; j <= R; j++) {
                if (map[j][i] != 0) {
                    int idx = map[j][i];
                    result += sharks.get(idx).size;
                    now.remove(sharks.get(idx));
                    map[j][i] = 0;
                    break;
                }
            }

            List<Shark> target = new ArrayList<>();

            // 상어가 이동한 후에, 이미 상어가 있다면 진행 차수가 같은지 검사하여 갱신
            for (Shark s : now) {
                s.cnt++;
                if (s.idx == map[s.r][s.c]) {
                    map[s.r][s.c] = 0;
                }
                int x = s.r;
                int y = s.c;
                int d = s.dir;

                // 상어 이동
                int dist = s.speed;

                if ((s.speed >= (R - 1)) && (d == 0 || d == 1)) {
                    int cnt = s.speed / (R - 1);

                    if (cnt % 2 == 1) {
                        x = (R + 1) - x;
                        d = d == 0 ? 1 : 0;
                    }

                    dist %= (R - 1);
                }

                if ((s.speed >= (C - 1)) && (d == 2 || d == 3)) {
                    int cnt = s.speed / (C - 1);

                    if (cnt % 2 == 1) {
                        y = (C + 1) - y;
                        d = d == 2 ? 3 : 2;
                    }

                    dist %= (C - 1);
                }

                for (int j = 0; j < dist; j++) {
                    int nx = x + dx[d];
                    int ny = y + dy[d];

                    if (nx < 1 || nx > R || ny < 1 || ny > C) {
                        if (d == 0) d = 1;
                        else if (d == 1) d = 0;
                        else if (d == 2) d = 3;
                        else d = 2;

                        x = nx + 2 * dx[d];
                        y = ny + 2 * dy[d];
                    } else {
                        x = nx;
                        y = ny;
                    }
                }

                // 상어 이동 갱신
                s.r = x;
                s.c = y;
                s.dir = d;

                // 이미 상어가 있는지 체크
                if (map[x][y] != 0 && sharks.get(map[x][y]).cnt == s.cnt) {
                    Shark o = sharks.get(map[x][y]);

                    if (o.size > s.size) {
                        target.add(s);
                    } else {
                        target.add(o);
                        map[x][y] = s.idx;
                    }
                } else {
                    map[x][y] = s.idx;
                }
            }

//            for (int j = 0; j <= R; j++) {
//                System.out.println(Arrays.toString(map[j]));
//            }
//            System.out.println();

            // 제거 대상
            for (Shark t : target) {
                now.remove(t);
            }
        }

        System.out.println(result);
    }
}

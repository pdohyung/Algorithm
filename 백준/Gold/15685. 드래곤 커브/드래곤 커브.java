
import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static boolean[][] map;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new boolean[101][101];
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken()); // 열
            int x = Integer.parseInt(st.nextToken()); // 행
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            draw(x, y, d, g);
        }

        int answer = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (map[i][j] && map[i + 1][j] && map[i][j + 1] && map[i + 1][j + 1]) answer++;
            }
        }
        System.out.println(answer);
    }

    private static void draw(int x, int y, int d, int g) {
        List<Integer> dirs = new ArrayList<>();
        dirs.add(d);

        // 모든 방향 저장
        for (int i = 0; i < g; i++) {
            for (int j = dirs.size() - 1; j >= 0; j--) {
                dirs.add((dirs.get(j) + 1) % 4);
            }
        }

        map[x][y] = true;
        for (int dir : dirs) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (nx < 0 || nx > 100 || ny < 0 || ny > 100) continue;

            map[nx][ny] = true;
            x = nx;
            y = ny;
        }
    }
}

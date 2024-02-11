import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    static int N, M, r, c, d, cnt;
    static int[][] map;
    static boolean[][] visit;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    void solution() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visit = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        cnt = 1;
        bfs(r, c, d);

        System.out.println(cnt);
    }

    private void bfs(int r, int c, int d) {
        visit[r][c] = true;

        for (int i = 0; i < 4; i++) {
            d = (d + 3) % 4;
            int nx = r + dx[d];
            int ny = c + dy[d];

            if (ny < 0 || ny >= M || nx < 0 || nx >= N) continue;
            if (visit[nx][ny] || map[nx][ny] != 0) continue;

            cnt++;
            bfs(nx, ny, d);
            return;
        }

        int nowDir = (d + 2) % 4;
        int nx = r + dx[nowDir];
        int ny = c + dy[nowDir];
        if (ny < 0 || ny >= M || nx < 0 || nx >= N || map[nx][ny] == 1) return;
        bfs(nx, ny, d);
    }
}
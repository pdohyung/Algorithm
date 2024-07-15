import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static int N, result;
    static int[][] map;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static int[][] sandsX = {
            {0, -1, 1, -1, 1, -2, 2, -1, 1},
            {2, 1, 1, 0, 0, 0, 0, -1, -1},
            {0, -1, 1, -1, 1, -2, 2, -1, 1},
            {-2, -1, -1, 0, 0, 0, 0, 1, 1}
    };
    static int[][] sandsY = {
            {-2, -1, -1, 0, 0, 0, 0, 1, 1},
            {0, -1, 1, -1, 1, -2, 2, -1, 1},
            {2, 1, 1, 0, 0, 0, 0, -1, -1},
            {0, -1, 1, -1, 1, -2, 2, -1, 1}
    };
    static double[] sandsPer = {0.05, 0.1, 0.1, 0.07, 0.07, 0.02, 0.02, 0.01, 0.01};

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    void solution() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int dir = 0;
        int x = N / 2;
        int y = N / 2;

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < i; k++) {
                    x += dx[dir];
                    y += dy[dir];
                    if (x < 0 || y < 0 || x >= N || y >= N) break;
                    wind(x, y, dir);
                }
                dir = (dir + 1) % 4;
            }
        }

        for (int i = 0; i < N - 1; i++) {
            x += dx[dir];
            y += dy[dir];
            wind(x, y, dir);
        }

        System.out.println(result);
    }

    static void wind(int x, int y, int dir) {
        int total = 0;

        for (int k = 0; k < 9; k++) {
            int nx = x + sandsX[dir][k];
            int ny = y + sandsY[dir][k];
            int sand = (int) (map[x][y] * sandsPer[k]);
            total += sand;
            if (ny >= N || ny < 0 || nx >= N || nx < 0) {
                result += sand;
            } else {
                map[nx][ny] += sand;
            }
        }

        int remainingSandX = x + dx[dir];
        int remainingSandY = y + dy[dir];
        int remainingSand = map[x][y] - total;
        if (remainingSandY >= N || remainingSandY < 0 || remainingSandX >= N || remainingSandX < 0) {
            result += remainingSand;
        } else {
            map[remainingSandX][remainingSandY] += remainingSand;
        }

        map[x][y] = 0;
    }
}
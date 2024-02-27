import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    static int N, M;
    static int[][] map;
    static int[][] dx = {
            {1, 1, 1}, {0, 0, 0},
            {0, 1, 0},
            {1, 1, 0}, {0, 0, -1}, {0, 1, 1}, {-1, 0, 0}, {0, -1, -1}, {-1, 0, 0}, {0, 1, 1}, {1, 0, 0},
            {1, 0, 1}, {0, -1, 0}, {1, 0, 1}, {0, 1, 0},
            {0, -1, 2}, {1, 0, 0}, {0, -1, 2}, {-1, 0, 0}};
    static int[][] dy = {
            {0, 0, 0}, {1, 1, 1},
            {1, 0, -1},
            {0, 0, 1}, {1, 1, 0}, {1, 0, 0}, {0, 1, 1}, {1, 0, 0}, {0, -1, -1}, {-1, 0, 0}, {0, 1, 1},
            {0, 1, 0}, {1, 0, 1}, {0, -1, 0}, {1, 0, 1},
            {1, 0, 0}, {0, -1, 2}, {-1, 0, 0}, {0, -1, 2}};

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    void solution() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        int res = 0;
        int max = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {

                for (int k = 0; k < dx.length; k++) {
                    //System.out.println("--------------");
                    res = map[i][j];
                    int nx = i;
                    int ny = j;
                    //System.out.println("first res = " + res);
                    for (int l = 0; l < dx[k].length; l++) {
                        nx += dx[k][l];
                        ny += dy[k][l];
                        //System.out.println("nx = " + nx + " ny = " + ny);
                        if (ny < 0 || ny >= M || nx < 0 || nx >= N) {
                            res = 0;
                            break;
                        }
                        res += map[nx][ny];
                        //System.out.println("res = " + res);
                    }
                    max = Math.max(max, res);
                    //System.out.println("max = " + max);
                    //System.out.println("--------------");
                }

            }
        }
        System.out.println(max);
    }
}

import java.util.*;
import java.io.*;

public class Main {

    static int N, M, x, y, K;
    static int[][] map;
    static int[] dice;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken()); // 주사위 시작 x
        y = Integer.parseInt(st.nextToken()); // 주사위 시작 y
        K = Integer.parseInt(st.nextToken());

        dice = new int[7];
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) map[i][j] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < K; i++) {
            int type = Integer.parseInt(st.nextToken());

            int nx = x + dx[type - 1];
            int ny = y + dy[type - 1];

            if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;

            if (type == 1) {
                swap(6, 4);
                swap(4, 1);
                swap(1, 3);
            } else if (type == 2) {
                swap(6, 3);
                swap(3, 1);
                swap(1, 4);
            } else if (type == 3) {
                swap(2, 6);
                swap(5, 6);
                swap(1, 5);
            } else if (type == 4) {
                swap(2, 6);
                swap(2, 1);
                swap(1, 5);
            }

            // 지도가 0이면 주사위 바닥면을 지도에 복사
            if (map[nx][ny] == 0) {
                map[nx][ny] = dice[1];
            } else { // 정수라면 주사위 바닥면에 복사
                dice[1] = map[nx][ny];
                map[nx][ny] = 0;
            }
            
            System.out.println(dice[6]);

            x = nx;
            y = ny;
        }
    }

    private static void swap(int idx1, int idx2) {
        int temp = dice[idx1];
        dice[idx1] = dice[idx2];
        dice[idx2] = temp;
    }
}

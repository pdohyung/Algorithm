
import java.util.*;
import java.io.*;

class Node {
    int x, y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {

    static int N, dir, answer;
    static int[][] map;
    static Node start;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static int[][] sandXDirs = {
            {0, 1, 1, 2, 1, -1, -1, -2, -1},
            {2, 1, 0, 0, -1, 1, 0, 0, -1},
            {0, -1, -1, -2, -1, 1, 1, 2, 1},
            {-2, -1, 0, 0, 1, -1, 0, 0, 1}
    };
    static int[][] sandYDirs = {
            {-2, -1, 0, 0, 1, -1, 0, 0, 1},
            {0, 1, 1, 2, 1, -1, -1, -2, -1},
            {2, 1, 0, 0, -1, 1, 0, 0, -1},
            {0, -1, -1, -2, -1, 1, 1, 2, 1}
    };
    static int[] percent = {5, 10, 7, 2, 1, 10, 7, 2, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) map[i][j] = Integer.parseInt(st.nextToken());
        }

        // 토네이도 시작
        start = new Node(N / 2, N / 2);
        dir = -1;
        tornado();

        System.out.println(answer);
    }

    private static void tornado() {
        // 중간부터 (0,0)까지 수행
        for (int i = 1; i < N; i++) {
            // 마지막은 3번 수행
            int cnt = 2;
            if (i == N - 1) cnt = 3;
            phase(cnt, i);
        }
    }

    private static void phase(int cnt, int n) {
        for (int i = 0; i < cnt; i++) {
            dir = (dir + 1) % 4; // dir 수정
            int x = start.x;
            int y = start.y;
            for (int j = 0; j < n; j++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];
                calculateSand(nx, ny);
                x = nx;
                y = ny;
            }
            // 시작 지점 업데이트
            start = new Node(x, y);
        }
    }

    private static void calculateSand(int x, int y) {
        int total = map[x][y];
        int remain = map[x][y];
        map[x][y] = 0;
        int[] xDirs = sandXDirs[dir];
        int[] yDirs = sandYDirs[dir];

        // 모래를 위치별로 저장
        for (int i = 0; i < xDirs.length; i++) {
            int nx = x + xDirs[i];
            int ny = y + yDirs[i];

            int sand = total * percent[i] / 100;
            remain -= sand;

            if (nx < 0 || nx >= N || ny < 0 || ny >= N) answer += sand;
            else map[nx][ny] += sand;
        }

        // 나머지 모래를 저장
        int nx = x + dx[dir];
        int ny = y + dy[dir];
        if (nx < 0 || nx >= N || ny < 0 || ny >= N) answer += remain;
        else map[nx][ny] += remain;
    }
}

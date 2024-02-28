import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    static int N, K, L;
    static int[][] map;
    static boolean[][] visit;
    static Map<Integer, String> directionInfo;
    static List<int[]> snake;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    void solution() throws IOException {
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visit = new boolean[N][N];
        directionInfo = new HashMap<>();
        snake = new ArrayList<>();

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map[x - 1][y - 1] = 1;
        }

        L = Integer.parseInt(br.readLine());

        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            int count = Integer.parseInt(st.nextToken());
            String changeDir = st.nextToken();
            directionInfo.put(count, changeDir);
        }

        int x = 0;
        int y = 0;
        snake.add(new int[]{x, y});
        int dir = 0;
        int cnt = 0;

        while (true) {
            cnt++;
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (isValid(nx, ny)) {
                break;
            }

            if (map[nx][ny] == 1) {
                map[nx][ny] = 0; // 사과 삭제
                snake.add(new int[]{nx, ny});
            } else { // 사과가 없을 때
                snake.add(new int[]{nx, ny});
                snake.remove(0);
            }

            x = nx;
            y = ny;

            if (directionInfo.containsKey(cnt)) {
                if (directionInfo.get(cnt).equals("L")) {
                    dir = (dir + 3) % 4;
                    continue;
                }
                if (directionInfo.get(cnt).equals("D")) {
                    dir = (dir + 1) % 4;
                }
            }
        }
        System.out.println(cnt);
    }

    private boolean isValid(int x, int y) {
        if (y < 0 || y >= N || x < 0 || x >= N || visit[x][y]) {
            return true;
        }

        for (int[] snakeArea : snake) {
            if (snakeArea[0] == x && snakeArea[1] == y) {
                return true;
            }
        }
        return false;
    }
}
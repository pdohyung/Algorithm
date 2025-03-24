
import java.util.*;
import java.io.*;

class Node {
    int x, y, val;
    int[] dir;

    public Node(int x, int y, int val, int[] dir) {
        this.x = x;
        this.y = y;
        this.val = val;
        this.dir = dir;
    }
}

public class Main {

    static int N, M, answer;
    static int[][] map;
    static int[][] dirs = {{0}, {0, 2}, {0, 3}, {0, 2, 3}, {0, 1, 2, 3}};
    static int[] cnt = {4, 2, 4, 4, 1};
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        List<Node> cctvs = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int val = Integer.parseInt(st.nextToken());
                if (val >= 1 && val <= 5) cctvs.add(new Node(i, j, val, dirs[val - 1]));
                map[i][j] = val;
            }
        }
        answer = Integer.MAX_VALUE;
        dfs(0, cctvs);
        System.out.println(answer);
    }

    private static void dfs(int depth, List<Node> cctvs) {
        if (depth == cctvs.size()) {
            answer = Math.min(answer, find(cctvs));
            return;
        }

        Node cctv = cctvs.get(depth);
        int val = cctv.val;
        int[] dir = cctv.dir;

        for (int j = 0; j < cnt[val - 1]; j++) {
            int[] newDir = new int[dir.length];
            for (int k = 0; k < dir.length; k++) newDir[k] = (dir[k] + j) % 4;
            cctv.dir = newDir;
            dfs(depth + 1, cctvs);
            cctv.dir = dir;
        }
    }

    private static int find(List<Node> cctvs) {
        int[][] nextMap = new int[N][M];
        boolean[][] check = new boolean[N][M];
        for (int i = 0; i < N; i++) nextMap[i] = map[i].clone();
        int cnt = 0;

        for (Node cctv : cctvs) {
            int[] nowDir = cctv.dir;
            for (int dir : nowDir) {
                int x = cctv.x;
                int y = cctv.y;
                while (true) {
                    int nx = x + dx[dir];
                    int ny = y + dy[dir];

                    if (nx < 0 || nx >= N || ny < 0 || ny >= M || nextMap[nx][ny] == 6) break;
                    if (nextMap[nx][ny] >= 1 && nextMap[nx][ny] <= 5) {
                        x = nx;
                        y = ny;
                        continue;
                    }

                    check[nx][ny] = true;
                    x = nx;
                    y = ny;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (nextMap[i][j] >= 1 && nextMap[i][j] <= 6 || check[i][j]) continue;
                cnt++;
            }
        }

        return cnt;
    }
}

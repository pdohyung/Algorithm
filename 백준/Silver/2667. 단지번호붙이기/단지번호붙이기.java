import java.io.*;
import java.util.*;

class Node {
    private final int x;
    private final int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int[][] map;
    static boolean[][] visit;
    static List<Integer> res;
    static int N;
    static int cnt;


    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    void solution() throws IOException {
        N = Integer.parseInt(br.readLine());
        map = new int[N + 1][N + 1];
        visit = new boolean[N + 1][N + 1];
        res = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                map[i][j] = -1;
            }
        }

        for (int i = 1; i <= N; i++) {
            String line = br.readLine();
            for (int j = 1; j <= N; j++) {
                map[i][j] = line.codePointAt(j - 1) - 48;
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (map[i][j] == 1 && !visit[i][j]) {
                    cnt = 1;
                    bfs(new Node(i, j));
                    res.add(cnt);
                }
            }
        }

        Collections.sort(res);
        System.out.println(res.size());
        for (Integer r : res) {
            System.out.println(r);
        }
    }

    private void bfs(Node node) {
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        visit[node.getX()][node.getY()] = true;

        while (!q.isEmpty()) {
            Node nowNode = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = nowNode.getX() + dx[i];
                int ny = nowNode.getY() + dy[i];

                if (ny < 0 || ny > N || nx < 0 || nx > N) continue;
                if (map[nx][ny] == 0 || visit[nx][ny]) continue;

                visit[nx][ny] = true;
                q.add(new Node(nx, ny));
                cnt++;
            }
        }
    }
}
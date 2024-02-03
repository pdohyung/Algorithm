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
    static int[][] res;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    void solution() throws IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        map = new int[n + 1][m + 1];
        visit = new boolean[n + 1][m + 1];
        res = new int[n + 1][m + 1];
        int startX = 0;
        int startY = 0;

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++) {
                int val = Integer.parseInt(st.nextToken());
                if (val == 2) {
                    startX = i;
                    startY = j;
                }
                map[i][j] = val;
                if (val == 0){
                    res[i][j] = 0;
                    continue;
                }
                res[i][j] = -1;
            }
        }

        Node node = new Node(startX, startY);
        visit[startX][startY] = true;
        res[startX][startY] = 0;
        Queue<Node> q = new LinkedList<>();
        q.add(node);

        while (!q.isEmpty()) {
            Node nowNode = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = nowNode.getX() + dx[i];
                int ny = nowNode.getY() + dy[i];

                if (ny < 0 || ny > m || nx < 0 || nx > n || visit[nx][ny]) continue;
                if (map[nx][ny] == 0){
                    res[nx][ny] = 0;
                    continue;
                }
                visit[nx][ny] = true;
                res[nx][ny] = res[nowNode.getX()][nowNode.getY()] + 1;
                q.add(new Node(nx, ny));
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
    }
}
import java.util.*;
import java.io.*;

class Node {
    int x, y;

    Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {

    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static List<Integer> result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];
        result = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            char[] line = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                if (line[j] == '0') map[i][j] = 0;
                else map[i][j] = 1;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && map[i][j] == 1) {
                    result.add(bfs(new Node(i, j)));
                }
            }
        }

        Collections.sort(result);
        System.out.println(result.size());
        for (int r : result) System.out.println(r);
    }

    static int bfs(Node start) {
        Queue<Node> q = new ArrayDeque<>();
        q.add(start);
        visited[start.x][start.y] = true;
        int cnt = 1;

        while (!q.isEmpty()) {
            Node now = q.poll();
            int x = now.x;
            int y = now.y;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                if (visited[nx][ny] || map[nx][ny] == 0) continue;

                visited[nx][ny] = true;
                q.add(new Node(nx, ny));
                cnt++;
            }
        }

        return cnt;
    }
}


import java.util.*;
import java.io.*;

class Node {
    int x;
    int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {

    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N + 1][N + 1];
        int max = 0;
        int answer = 1;

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max, map[i][j]);
            }
        }

        for (int i = 2; i <= max; i++) {
            visited = new boolean[N + 1][N + 1];

            for (int j = 1; j <= N; j++) {
                for (int k = 1; k <= N; k++) {

                    if (map[j][k] < i) {
                        visited[j][k] = true;
                    }
                }
            }

            int cnt = 0;

//            for (int j = 1; j <= N; j++) {
//                System.out.println(Arrays.toString(visited[j]));
//            }

            for (int j = 1; j <= N; j++) {
                for (int k = 1; k <= N; k++) {
                    if (bfs(new Node(j, k))) {
                        cnt++;
                    }
                }
            }

//            for (int j = 1; j <= N; j++) {
//                System.out.println(Arrays.toString(visited[j]));
//            }

            answer = Math.max(answer, cnt);
        }

        System.out.println(answer);
    }

    private static boolean bfs(Node start) {
        int startX = start.x;
        int startY = start.y;

        if (visited[startX][startY]) {
            return false;
        }

        ArrayDeque<Node> q = new ArrayDeque<>();
        q.add(start);
        visited[startX][startY] = true;

        while (!q.isEmpty()) {
            Node now = q.poll();
            int x = now.x;
            int y = now.y;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx > N || nx < 1 || ny > N || ny < 1) continue;
                if (visited[nx][ny]) continue;

                visited[nx][ny] = true;
                q.add(new Node(nx, ny));
            }
        }

        return true;
    }
}

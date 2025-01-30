
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

    static int N, M;
    static int[][] nMap;
    static boolean[][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        ArrayList<Node> targets = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            char[] line = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                if (line[j] == 'L') {
                    targets.add(new Node(i, j));
                    map[i][j] = 0;
                } else {
                    map[i][j] = -1;
                }
            }
        }

        int max = Integer.MIN_VALUE;

        for (Node target : targets) {
            visited = new boolean[N][M];
            nMap = new int[N][M];
            for (int i = 0; i < N; i++) nMap[i] = map[i].clone();

            max = Math.max(max, bfs(target));
//            for (int i = 0; i < N; i++) {
//                System.out.println(Arrays.toString(nMap[i]));
//            }
        }

        System.out.println(max);
    }

    private static int bfs(Node start) {
        ArrayDeque<Node> q = new ArrayDeque<>();
        q.add(start);
        visited[start.x][start.y] = true;
        int max = 0;

        while (!q.isEmpty()) {
            Node now = q.poll();
            int x = now.x;
            int y = now.y;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (ny < 0 || ny >= M || nx < 0 || nx >= N) continue;
                if (visited[nx][ny] || nMap[nx][ny] == -1) continue;

                visited[nx][ny] = true;
                q.add(new Node(nx, ny));
                nMap[nx][ny] = nMap[x][y] + 1;
                max = Math.max(max, nMap[nx][ny]);
//                System.out.println(nx + " " + ny);
            }
        }

//        System.out.println(max);
        return max;
    }
}

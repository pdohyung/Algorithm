
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
    static int[][] map, nMap;
    static boolean[][] visited;
    static ArrayList<Node> targets;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        nMap = new int[N][M];
        targets = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                int h = Integer.parseInt(st.nextToken());
                if (h != 0) targets.add(new Node(i, j));
                map[i][j] = h;
            }
        }

        int answer = 0;

        while (true) {
            if (targets.isEmpty()) {
                System.out.println(0);
                return;
            }

            visited = new boolean[N][M];
            bfs(targets.get(0));
            for (Node target : targets) {
                if (!visited[target.x][target.y]) {
                    System.out.println(answer);
                    return;
                }
            }
            answer++;

            ArrayList<Node> newTargets = new ArrayList<>();
            for (int i = 0; i < N; i++) nMap[i] = map[i].clone();

            for (Node target : targets) {
                int x = target.x;
                int y = target.y;
                int cnt = 0;

                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if (nx < 0 || nx >= N || ny < 0 || ny >= M || map[nx][ny] != 0) continue;

                    cnt++;
                }

                if (map[x][y] - cnt > 0) {
                    nMap[x][y] = map[x][y] - cnt;
                    newTargets.add(new Node(x, y));
                } else {
                    nMap[x][y] = 0;
                }
            }

            targets = new ArrayList<>(newTargets);
            for (int i = 0; i < N; i++) map[i] = nMap[i].clone();

//            for (int i = 0; i < N; i++) System.out.println(Arrays.toString(map[i]));
        }
    }

    private static void bfs(Node start) {
        ArrayDeque<Node> q = new ArrayDeque<>();
        q.add(start);
        visited[start.x][start.y] = true;

        while (!q.isEmpty()) {
            Node now = q.pop();
            int x = now.x;
            int y = now.y;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M || map[nx][ny] == 0 || visited[nx][ny]) continue;

                visited[nx][ny] = true;
                q.add(new Node(nx, ny));
            }
        }
    }
}

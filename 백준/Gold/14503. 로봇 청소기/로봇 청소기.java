import java.util.*;
import java.io.*;

class Node {
    int x;
    int y;
    int d;

    public Node(int x, int y, int d) {
        this.x = x;
        this.y = y;
        this.d = d;
    }
}

public class Main {

    static int N, M, r, c, d, answer;
    static int[][] map;
    static int[] dx = {-1, 0, 1, 0}; // 북 동 남 서
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs(new Node(r, c, d));

        System.out.println(answer);
    }

    private static void bfs(Node start) {
        Queue<Node> q = new ArrayDeque<>();
        q.add(start);

        while (!q.isEmpty()) {
            Node now = q.poll();
            int x = now.x;
            int y = now.y;
            int dir = now.d;

            if (map[x][y] == 0) {
                answer++;
                map[x][y] = -1;
            }

            boolean flag = true;
            int cnt = 0;
            int nextDir = dir;
            
            // 바라보는 방향에서부터 진행
            while (cnt < 4) {
                cnt++;
                nextDir = (nextDir + 3) % 4;

                int nx = x + dx[nextDir];
                int ny = y + dy[nextDir];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M || map[nx][ny] == 1 || map[nx][ny] == -1) continue;

                flag = false;
                map[nx][ny] = -1;
                answer++;
                q.add(new Node(nx, ny, nextDir));
                break;
            }

            // 청소되지 않은 빈칸이 없는 경우
            if (flag) {
                nextDir = (dir + 2) % 4;
                int nx = x + dx[nextDir];
                int ny = y + dy[nextDir];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M || map[nx][ny] == 1) return;
                else {
                    q.add(new Node(nx, ny, dir));
                }
            }
        }
    }
}

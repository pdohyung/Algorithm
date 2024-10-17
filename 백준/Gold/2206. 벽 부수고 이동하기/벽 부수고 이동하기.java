import java.io.*;
import java.util.*;

class Node {
    int x, y, wall;

    Node(int x, int y, int wall) {
        this.x = x;
        this.y = y;
        this.wall = wall; // 벽을 부순 여부 (0: 부수지 않음, 1: 부숨)
    }
}

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static int N, M;
    static int[][] map;
    static boolean[][][] visited; // [x][y][wall] 상태 방문 체크

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M][2]; // 벽을 부순 여부에 따라 2차원 배열 사용

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        int result = bfs();
        System.out.println(result);
    }

    static int bfs() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0, 0)); // 시작점 (0, 0)에서 벽을 부수지 않은 상태로 시작
        visited[0][0][0] = true;

        int steps = 1; // 시작 지점도 포함해 1로 시작

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Node now = queue.poll();

                if (now.x == N - 1 && now.y == M - 1) {
                    return steps; // 도착 지점에 도달하면 반환
                }

                for (int d = 0; d < 4; d++) {
                    int nx = now.x + dx[d];
                    int ny = now.y + dy[d];

                    if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue; // 범위 체크

                    // 벽이 없고, 아직 방문하지 않은 경우
                    if (map[nx][ny] == 0 && !visited[nx][ny][now.wall]) {
                        visited[nx][ny][now.wall] = true;
                        queue.add(new Node(nx, ny, now.wall));
                    }

                    // 벽이 있고, 아직 벽을 부수지 않은 경우
                    if (map[nx][ny] == 1 && now.wall == 0 && !visited[nx][ny][1]) {
                        visited[nx][ny][1] = true;
                        queue.add(new Node(nx, ny, 1)); // 벽을 부순 상태로 추가
                    }
                }
            }
            steps++;
        }
        return -1; // 도달할 수 없는 경우 -1 반환
    }
}


import java.util.*;
import java.io.*;

class Node {
    int x, y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {

    static int N, L, R;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) map[i][j] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;

        while (true) {
            visited = new boolean[N][N];
            int cnt = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (visited[i][j] || !isValid(i, j)) continue;
//                    System.out.println("처음 루프" + i + " " + j);
                    Queue<Node> result = bfs(new Node(i, j));// 반환한 큐를 가지고 인구를 수정한다.
//                    System.out.println(result);
                    updateMap(result);
                }
            }

//            for (int k = 0; k < N; k++) {
//                System.out.println(Arrays.toString(map[k]));
//            }
//            System.out.println();

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) if (visited[i][j]) cnt++;
            }

            if (cnt == 0) break;
            answer++;
        }

        System.out.println(answer);
    }

    private static Queue<Node> bfs(Node start) {
        Queue<Node> result = new ArrayDeque<>();
        Queue<Node> q = new ArrayDeque<>();
        q.add(start);
        result.add(start);
        visited[start.x][start.y] = true;

        while (!q.isEmpty()) {
            Node now = q.poll();
            int x = now.x;
            int y = now.y;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny]) continue;
                int diff = Math.abs(map[nx][ny] - map[x][y]);
                if (!(L <= diff && R >= diff)) continue;

                visited[nx][ny] = true;
                Node next = new Node(nx, ny);
                q.add(next);
                result.add(next);
            }
        }

        return result;
    }

    private static boolean isValid(int x, int y) {
        int cnt = 0;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
            int diff = Math.abs(map[nx][ny] - map[x][y]);
//            System.out.println(x + " " + y + " " + nx + " " + ny + " " + diff);
            if (L <= diff && R >= diff) cnt++;
        }

        return cnt > 0;
    }

    private static void updateMap(Queue<Node> result) {
        int cnt = result.size();
        int sum = 0;
        Queue<Node> temp = new ArrayDeque<>();

        while (!result.isEmpty()) {
            Node now = result.poll();
            sum += map[now.x][now.y];
            temp.add(now);
        }

        int each = sum / cnt;

        while (!temp.isEmpty()) {
            Node now = temp.poll();
            map[now.x][now.y] = each;
        }
    }
}

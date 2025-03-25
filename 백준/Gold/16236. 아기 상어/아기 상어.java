
import java.util.*;
import java.io.*;

class Node {
    int x, y, d;

    public Node(int x, int y, int d) {
        this.x = x;
        this.y = y;
        this.d = d;
    }
}

public class Main {

    static int N, size;
    static int[][] map;
    static boolean[][] visited;
    static List<Node> fishes;
    static Node baby;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num == 9) baby = new Node(i, j, 0);
                map[i][j] = num;
            }
        }

        size = 2;
        int need = size;
        int sec = 0;
        fishes = new ArrayList<>();
        findFishes();

        while (!fishes.isEmpty()) {
            // 물고기 먹고, 위치 업데이트
            Node fish = fishes.get(0);
            int d = fish.d;
            fish.d = 0;
            map[fish.x][fish.y] = 9;
            map[baby.x][baby.y] = 0;
            baby = fish;

            // 크기만큼 물고기를 먹으면 사이즈가 커진다
            need--;
            if (need == 0) {
                size++;
                need = size;
            }

            // 먹을 수 있는 물고기 업데이트
            fishes = new ArrayList<>();
            visited = new boolean[N][N];
            findFishes();

            // 시간 증가
            sec += d;
        }

        System.out.println(sec);
    }

    private static void bfs(Node start) {
        Queue<Node> q = new ArrayDeque<>();
        q.add(start);
        visited[start.x][start.y] = true;

        while (!q.isEmpty()) {
            Node now = q.poll();
            int x = now.x;
            int y = now.y;
            int d = now.d;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                if (visited[nx][ny] || map[nx][ny] > size) continue;

                visited[nx][ny] = true;
                q.add(new Node(nx, ny, d + 1));
                if (map[nx][ny] == 0 || map[nx][ny] == size) continue;
                fishes.add(new Node(nx, ny, d + 1));
            }
        }
    }

    // 먹을 수 있는 물고기 찾기
    private static void findFishes() {
        bfs(baby);
        fishes.sort((a, b) -> {
            if (a.d != b.d) return Integer.compare(a.d, b.d);
            if (a.x == b.x) return Integer.compare(a.y, b.y);
            return Integer.compare(a.x, b.x);
        });
    }
}

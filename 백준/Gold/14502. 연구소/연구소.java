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
    static int[][] temp;
    static boolean[][] visit;
    static int N;
    static int M;
    static int cnt;
    static int max;
    static List<Node> candidates;
    static List<Node> virus;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    void solution() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N + 1][M + 1];
        visit = new boolean[N + 1][M + 1];
        candidates = new ArrayList<>();
        virus = new ArrayList<>();
        max = 0;

        for (int i = 0; i <= N; i++) {
            Arrays.fill(map[i], -1);
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                int val = Integer.parseInt(st.nextToken());
                if (val == 0) {
                    candidates.add(new Node(i, j));
                }
                if (val == 2) {
                    visit[i][j] = true;
                    virus.add(new Node(i, j));
                }
                map[i][j] = val;
            }
        }

        for (int i = 0; i < candidates.size(); i++) {
            for (int j = i + 1; j < candidates.size(); j++) {
                for (int k = j + 1; k < candidates.size(); k++) {
                    cnt = 0;
                    visit = new boolean[N + 1][M + 1];
                    temp = new int[N + 1][M + 1];
                    for (int l = 0; l <= N; l++) {
                        temp[l] = Arrays.copyOf(map[l], M + 1);
                    }

                    temp[candidates.get(i).getX()][candidates.get(i).getY()] = 1;
                    temp[candidates.get(j).getX()][candidates.get(j).getY()] = 1;
                    temp[candidates.get(k).getX()][candidates.get(k).getY()] = 1;

                    bfs();
                    count();
                    max = Math.max(cnt, max);
                }
            }
        }
        System.out.println(max);
    }

    private void bfs() {
        Queue<Node> q = new LinkedList<>(virus);
        while (!q.isEmpty()) {
            Node nowNode = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = nowNode.getX() + dx[i];
                int ny = nowNode.getY() + dy[i];

                if (ny < 0 || ny > M || nx < 0 || nx > N) continue;
                if (visit[nx][ny] || temp[nx][ny] != 0) continue;

                visit[nx][ny] = true;
                temp[nx][ny] = 2;
                q.add(new Node(nx, ny));
            }
        }
    }

    private void count() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (temp[i][j] == 0) {
                    cnt++;
                }
            }
        }
    }
}
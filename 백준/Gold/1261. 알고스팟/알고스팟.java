
import java.util.*;
import java.io.*;

class Node {
    int x;
    int y;
    int cnt;

    public Node(int x, int y, int cnt) {
        this.x = x;
        this.y = y;
        this.cnt = cnt;
    }
}

public class Main {

    static int N, M;
    static int[][] map;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            char[] line = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                if (line[j] == '1') {
                    map[i][j] = 1;
                } else {
                    map[i][j] = 0;
                }
            }
        }

        int dist[][] = new int[N][M];
        for (int i = 0; i < N; i++) Arrays.fill(dist[i], Integer.MAX_VALUE);
        dist[0][0] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cnt, o2.cnt));
        pq.add(new Node(0, 0, 0));

        while (!pq.isEmpty()) {
            Node now = pq.poll();
            int x = now.x;
            int y = now.y;
            int cnt = now.cnt;

            if (dist[x][y] < cnt) continue;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (ny < 0 || ny >= M || nx < 0 || nx >= N) continue;

                int newCnt = map[nx][ny] + cnt;

                if (dist[nx][ny] > newCnt) {
                    dist[nx][ny] = newCnt;
                    pq.add(new Node(nx, ny, newCnt));
                }
            }
        }

        System.out.println(dist[N - 1][M - 1]);
    }
}

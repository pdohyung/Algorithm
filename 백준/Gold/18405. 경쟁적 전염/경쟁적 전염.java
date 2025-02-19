
import java.util.*;
import java.io.*;

class Node {
    int x;
    int y;
    int type;
    int sec;

    public Node(int x, int y, int type, int sec) {
        this.x = x;
        this.y = y;
        this.type = type;
        this.sec = sec;
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] map = new int[N + 1][N + 1];
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1.sec != o2.sec) return Integer.compare(o1.sec, o2.sec);
            return Integer.compare(o1.type, o2.type);
        });

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int type = Integer.parseInt(st.nextToken());
                if (type == 0) continue;
                pq.add(new Node(i, j, type, 0));
                map[i][j] = type;
            }
        }

        st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while (!pq.isEmpty()) {
            Node now = pq.poll();
            int x = now.x;
            int y = now.y;
            int type = now.type;
            int sec = now.sec;

            if (sec >= S) continue;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx <= 0 || nx > N || ny <= 0 || ny > N || map[nx][ny] != 0) continue;

                map[nx][ny] = type;
                pq.add(new Node(nx, ny, type, sec + 1));
            }
        }

        System.out.println(map[X][Y]);
    }
}

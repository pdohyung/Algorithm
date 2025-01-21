
import java.util.*;
import java.io.*;

class Node {
    int x;
    int y;
    int dir;

    public Node(int x, int y, int dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
    }
}

public class Main {

    static int N;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                int n = Integer.parseInt(st.nextToken());

                if (n == 1) {
                    map[i][j] = -1;
                } else {
                    map[i][j] = 0;
                }
            }
        }
        map[0][1] = 1;
        bfs(new Node(0, 1, 0));

//        for (int i = 0; i < N; i++) {
//            System.out.println(Arrays.toString(map[i]));
//        }

        if (map[N - 1][N - 1] == -1) {
            System.out.println(0);
            return;
        }
        System.out.println(map[N - 1][N - 1]);
    }

    private static void bfs(Node start) {
        ArrayDeque<Node> q = new ArrayDeque<>();
        q.add(start);

        while (!q.isEmpty()) {
            Node next = q.poll();
            int x = next.x;
            int y = next.y;
            int dir = next.dir;

            if (dir == 0) {
                if (isValidC(x, y)) {
                    map[x][y + 1] += 1;
                    q.add(new Node(x, y + 1, 0));
                }

                if (isValidCross(x, y)) {
                    map[x + 1][y + 1] += 1;
                    q.add(new Node(x + 1, y + 1, 2));
                }
            } else if (dir == 1) {
                if (isValidR(x, y)) {
                    map[x + 1][y] += 1;
                    q.add(new Node(x + 1, y, 1));
                }

                if (isValidCross(x, y)) {
                    map[x + 1][y + 1] += 1;
                    q.add(new Node(x + 1, y + 1, 2));
                }
            } else if (dir == 2) {

                if (isValidC(x, y)) {
                    map[x][y + 1] += 1;
                    q.add(new Node(x, y + 1, 0));
                }

                if (isValidR(x, y)) {
                    map[x + 1][y] += 1;
                    q.add(new Node(x + 1, y, 1));
                }

                if (isValidCross(x, y)) {
                    map[x + 1][y + 1] += 1;
                    q.add(new Node(x + 1, y + 1, 2));
                }
            }
        }
    }

    private static boolean isValidR(int x, int y) {
        return x + 1 < N && map[x + 1][y] != -1;
    }

    private static boolean isValidC(int x, int y) {
        return y + 1 < N && map[x][y + 1] != -1;
    }

    private static boolean isValidCross(int x, int y) {
        return x + 1 < N && y + 1 < N && map[x + 1][y] != -1 && map[x][y + 1] != -1 && map[x + 1][y + 1] != -1;
    }
}

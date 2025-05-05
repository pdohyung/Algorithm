
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

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[][] map = new int[R][C];
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                if (line.charAt(j) == '.') {
                    map[i][j] = 0;
                } else map[i][j] = 2;
            }
        }

        N--;

        while (N > 0) {
            Queue<Node> q = new ArrayDeque<>();

            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (map[i][j] == 0) map[i][j] = 3;
                    else map[i][j]--;

                    if (map[i][j] == 1) q.offer(new Node(i, j));
                }
            }

            if (--N == 0) break;

            while (!q.isEmpty()) {
                Node now = q.poll();
                int x = now.x;
                int y = now.y;
                map[x][y] = 0;

                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if (nx < 0 || nx >= R || ny < 0 || ny >= C || map[nx][ny] == 0) continue;

                    map[nx][ny] = 0;
                }
            }

            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (map[i][j] > 0) map[i][j]--;
                }
            }

            if (--N == 0) break;
        }

        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == 0) answer.append(".");
                else answer.append("O");
            }
            answer.append("\n");
        }

        System.out.println(answer);
    }
}

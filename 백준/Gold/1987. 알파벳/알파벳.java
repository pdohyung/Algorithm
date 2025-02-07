import java.util.*;
import java.io.*;

public class Main {
    static int R, C, max = 0;
    static char[][] board;
    static boolean[] visited = new boolean[26]; // 알파벳 방문 여부 체크
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        board = new char[R][C];

        for (int i = 0; i < R; i++) {
            board[i] = br.readLine().toCharArray();
        }

        visited[board[0][0] - 'A'] = true;
        dfs(0, 0, 1);

        System.out.println(max);
    }

    static void dfs(int x, int y, int count) {
        max = Math.max(max, count);

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= R || ny < 0 || ny >= C) continue;

            int nextChar = board[nx][ny] - 'A';

            if (!visited[nextChar]) {
                visited[nextChar] = true;
                dfs(nx, ny, count + 1);
                visited[nextChar] = false;
            }
        }
    }
}

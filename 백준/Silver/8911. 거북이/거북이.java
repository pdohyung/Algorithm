import java.io.*;
import java.util.*;

public class Main {

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int N;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;


    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    void solution() throws IOException {
        N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();


        for (int i = 0; i < N; i++) {
            int x = 0, y = 0, minX = 0, minY = 0, maxX = 0, maxY = 0, dir = 0;
            String command = br.readLine();

            for (Character c : command.toCharArray()) {
                if (c == 'F') {
                    x += dx[dir];
                    y += dy[dir];
                } else if (c == 'B') {
                    x -= dx[dir];
                    y -= dy[dir];
                } else if (c == 'L') {
                    dir = (dir + 3) % 4;
                } else if (c == 'R') {
                    dir = (dir + 1) % 4;
                }

                minX = Math.min(minX, x);
                minY = Math.min(minY, y);
                maxX = Math.max(maxX, x);
                maxY = Math.max(maxY, y);
            }
            sb.append(Math.abs(maxX - minX) * Math.abs(maxY - minY)).append("\n");
        }
        System.out.println(sb.toString());
        return;
    }
}

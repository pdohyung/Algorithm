import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] result;
    static int[][] square;
    static int N;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    void solution() throws IOException {
        N = Integer.parseInt(br.readLine());
        square = new int[N][N];
        result = new int[2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                square[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solve(0, N, 0, N);

        System.out.println(result[0]);
        System.out.println(result[1]);
        return;
    }

    static void solve(int x1, int x2, int y1, int y2) {
        if (x2 - x1 == 1) {
            plus(x1, y1);
            return;
        }
        int now = square[x1][y1];
        for (int i = x1; i < x2; i++) {
            for (int j = y1; j < y2; j++) {
                if (now != square[i][j]) {
                    //System.out.println(i + " " + j);
                    solve(x1, (x1 + x2) / 2, y1, (y1 + y2) / 2);
                    solve((x1 + x2) / 2, x2, (y1 + y2) / 2, y2);
                    solve((x1 + x2) / 2, x2, y1, (y1 + y2) / 2);
                    solve(x1, (x1 + x2) / 2, (y1 + y2) / 2, y2);
                    return;
                }
            }
        }

        plus(x1, y1);
    }

    static void plus(int x, int y) {
        if (square[x][y] == 1) {
            result[1]++;
            return;
        }
        result[0]++;
    }

}

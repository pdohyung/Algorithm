import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static int N;
    static int[][] square;
    static StringBuilder sb;


    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    void solution() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        square = new int[N][N];
        sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                square[i][j] = s.charAt(j) - 48;
            }
        }

        solve(0, N, 0, N);

//        for (int i = 0; i < N; i++) {
//            System.out.println(Arrays.toString(square[i]));
//        }
        System.out.println(sb);
        return;
    }

    static void solve(int x1, int x2, int y1, int y2) {
        if (x2 - x1 == 1) {
            sb.append(square[x1][y1]);
            return;
        }

        int first = square[x1][y1];

        for (int i = x1; i < x2; i++) {
            for (int j = y1; j < y2; j++) {
                if (first != square[i][j]) {
                    sb.append("(");
                    solve(x1, (x1 + x2) / 2, y1, (y1 + y2) / 2);
                    solve(x1, (x1 + x2) / 2, (y1 + y2) / 2, y2);
                    solve((x1 + x2) / 2, x2, y1, (y1 + y2) / 2);
                    solve((x1 + x2) / 2, x2, (y1 + y2) / 2, y2);
                    sb.append(")");
                    return;
                }
            }
        }
        sb.append(first);
    }

}


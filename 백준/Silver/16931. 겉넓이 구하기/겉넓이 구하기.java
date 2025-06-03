
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        // 3차원 도형을 각 면에서 바라본 결과를 다 더함
        // 왼쪽, 오른쪽, 위쪽, 아럐쪽
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] H = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                H[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = N * M * 2;

        for (int i = 0; i < N; i++) {
            int before = 0;

            for (int j = 0; j < M; j++) {
                int now = H[i][j] - before;
                if (now > 0) {
                    answer += now;
                }
                before = H[i][j];
            }

            before = 0;

            for (int j = M - 1; j >= 0; j--) {
                int now = H[i][j] - before;
                if (now > 0) {
                    answer += now;
                }
                before = H[i][j];
            }
        }

        for (int i = 0; i < M; i++) {
            int before = 0;

            for (int j = 0; j < N; j++) {
                int now = H[j][i] - before;
                if (now > 0) {
                    answer += now;
                }
                before = H[j][i];
            }

            before = 0;

            for (int j = N - 1; j >= 0; j--) {
                int now = H[j][i] - before;
                if (now > 0) {
                    answer += now;
                }
                before = H[j][i];
            }
        }

        System.out.println(answer);
    }
}

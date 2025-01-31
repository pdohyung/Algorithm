
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] A = new int[N + 1][3];
        int[][] dp1 = new int[N + 1][3];
        int[][] dp2 = new int[N + 1][3];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            A[i][0] = Integer.parseInt(st.nextToken());
            A[i][1] = Integer.parseInt(st.nextToken());
            A[i][2] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            dp1[i][0] = Math.min(dp1[i - 1][0], dp1[i - 1][1]) + A[i][0];
            dp1[i][1] = Math.min(Math.min(dp1[i - 1][0], dp1[i - 1][1]), dp1[i - 1][2]) + A[i][1];
            dp1[i][2] = Math.min(dp1[i - 1][1], dp1[i - 1][2]) + A[i][2];

            dp2[i][0] = Math.max(dp2[i - 1][0], dp2[i - 1][1]) + A[i][0];
            dp2[i][1] = Math.max(Math.max(dp2[i - 1][0], dp2[i - 1][1]), dp2[i - 1][2]) + A[i][1];
            dp2[i][2] = Math.max(dp2[i - 1][1], dp2[i - 1][2]) + A[i][2];
        }

        System.out.print(Math.max(Math.max(dp2[N][0], dp2[N][1]), dp2[N][2]) + " " + Math.min(Math.min(dp1[N][0], dp1[N][1]), dp1[N][2]));
    }
}


import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder answer = new StringBuilder();

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            int[][] A = new int[n][n];

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    A[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int[][] result = rotate(A, n, d);

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    answer.append(result[i][j]).append(" ");
                }
                answer.append("\n");
            }
        }

        System.out.println(answer);
    }

    static int[][] rotate(int[][] A, int n, int d) {
        int[][] result = new int[n][n];
        for (int i = 0; i < n; i++) result[i] = A[i].clone();
        int cnt = Math.abs(d / 45);

        if (d < 0) {
            for (int c = 0; c < cnt; c++) {
                for (int i = 0; i < n; i++) {
                    result[i][i] = A[i][n / 2];
                    result[n / 2][i] = A[i][i];
                    result[n - i - 1][i] = A[n / 2][i];
                    result[n - i - 1][n / 2] = A[n - i - 1][i];
                }

                for (int i = 0; i < n; i++) A[i] = result[i].clone();
            }
        } else {
            for (int c = 0; c < cnt; c++) {
                for (int i = 0; i < n; i++) {
                    result[i][n - i - 1] = A[i][n / 2];
                    result[n / 2][n - i - 1] = A[i][n - i - 1];
                    result[i][i] = A[n / 2][i];
                    result[i][n / 2] = A[i][i];
                }

                for (int i = 0; i < n; i++) A[i] = result[i].clone();
            }
        }

        return result;
    }
}

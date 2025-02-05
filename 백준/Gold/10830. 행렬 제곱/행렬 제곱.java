
import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static long B;
    static int[][] matrix;
    static int MOD = 1_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        B = Long.parseLong(st.nextToken());

        matrix = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] result = exp(matrix, B);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }

    static int[][] matrixMultiple(int[][] A, int[][] B) {
        int[][] result = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    result[i][j] = (result[i][j] + A[i][k] * B[k][j]) % MOD;
                }
            }
        }

        return result;
    }

    static int[][] exp(int[][] A, long exp) {
        if (exp == 1) {
            int[][] result = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    result[i][j] = A[i][j] % MOD;
                }
            }
            return result;
        }

        if (exp % 2 == 0) {
            int[][] half = exp(A, exp / 2);
            return matrixMultiple(half, half);
        } else {
            return matrixMultiple(A, exp(A, exp - 1));
        }
    }
}

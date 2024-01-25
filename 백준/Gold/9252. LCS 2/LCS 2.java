import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    static StringBuilder sb;
    static int[][] D;
    static char[] A;
    static char[] B;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    void solution() throws IOException {
        A = br.readLine().toCharArray();
        B = br.readLine().toCharArray();
        sb = new StringBuilder();
        D = new int[A.length + 1][B.length + 1];

        for (int i = 1; i <= A.length; i++) {
            for (int j = 1; j <= B.length; j++) {
                if (A[i - 1] == B[j - 1]) {
                    D[i][j] = D[i - 1][j - 1] + 1;
                    continue;
                }
                D[i][j] = Math.max(D[i - 1][j], D[i][j - 1]);
            }
        }

        getLCS(A.length, B.length);
        System.out.println(D[A.length][B.length]);
        System.out.println(sb.reverse().toString());
    }

    private void getLCS(int r, int c) {
        if (r == 0 || c == 0) {
            return;
        }

        if (A[r - 1] == B[c - 1]) {
            sb.append(A[r - 1]);
            getLCS(r - 1, c - 1);
        } else {
            if (D[r - 1][c] > D[r][c - 1]) {
                getLCS(r - 1, c);
            } else {
                getLCS(r, c - 1);
            }
        }
    }
}
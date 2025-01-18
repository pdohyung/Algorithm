
import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int[][] tree;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        tree = new int[N + 1][N + 1];
        dp = new int[N + 1][N + 1];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j <= i; j++) {
                tree[i][j] = Integer.parseInt(st.nextToken());
            }
        }

//        for (int i = 0; i < N; i++) {
//            System.out.println(Arrays.toString(tree[i]));
//        }

        for (int i = N - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                tree[i][j] += Math.max(tree[i + 1][j], tree[i + 1][j + 1]);
            }
        }

        System.out.println(tree[0][0]);
    }
}

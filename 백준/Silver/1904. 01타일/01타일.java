import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    static int[] D;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    void solution() throws IOException {
        int N = Integer.parseInt(br.readLine());
        D = new int[N + 2];
        D[1] = 1;
        D[2] = 2;

        for (int i = 3; i <= N; i++) {
            D[i] = (D[i - 1] + D[i - 2]) % 15746;
        }
        System.out.println(D[N]);
    }
}
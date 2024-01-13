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
        int n = Integer.parseInt(br.readLine());
        D = new int[n + 1];
        D[1] = 0;
        for (int i = 2; i <= n; i++) {
            D[i] = D[i - 1] + 1;
            if (i % 2 == 0){
                D[i] = Math.min(D[i], D[i / 2] + 1);
            }
            if (i % 3 == 0){
                D[i] = Math.min(D[i], D[i / 3] + 1);
            }
        }
        System.out.println(D[n]);
    }
}
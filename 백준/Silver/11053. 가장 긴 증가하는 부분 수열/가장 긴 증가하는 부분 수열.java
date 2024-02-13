import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    static int[] D;
    static int[] A;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    void solution() throws IOException {
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        D = new int[N + 1];
        A = new int[N + 1];
        int max = 0;

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            D[i] = 1;
            for (int j = 0; j < i; j++) {
                if (A[j] < A[i] && D[i] < D[j] + 1){
                    D[i] = D[j] + 1;
                }
            }
            max = Math.max(D[i], max);
        }
        System.out.println(max);
    }
}
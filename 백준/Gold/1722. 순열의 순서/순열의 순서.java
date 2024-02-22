import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    static int N;
    static long K;
    static long[] f;
    static boolean[] visit;
    static int[] res;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    void solution() throws IOException {

        N = Integer.parseInt(br.readLine());
        f = new long[21];
        visit = new boolean[21];
        res = new int[21];
        st = new StringTokenizer(br.readLine());
        int q = Integer.parseInt(st.nextToken());

        f[0] = 1;
        for (int i = 1; i <= N; i++) {
            f[i] = f[i - 1] * i;
        }

        if (q == 1) {
            K = Long.parseLong(st.nextToken());
            for (int i = 0; i < N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (visit[j]) continue;
                    if (f[N - i - 1] < K) {
                        K -= f[N - i - 1];
                    } else {
                        res[i] = j;
                        visit[j] = true;
                        break;
                    }
                }
            }
            for (int i = 0; i < N; i++) {
                System.out.print(res[i] + " ");
            }
        } else {
            for (int i = 0; i < N; i++) {
                res[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < N; i++) {
                for (int j = 1; j < res[i]; j++) {
                    if (visit[j]) continue;
                    K += f[N - 1 - i];
                }
                visit[res[i]] = true;
            }
            System.out.println(K + 1);
        }
    }
}
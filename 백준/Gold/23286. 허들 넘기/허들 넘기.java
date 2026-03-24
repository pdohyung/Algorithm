import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        int[][] dist = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
            dist[i][i] = 0;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            dist[s][e] = v;
        }

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    dist[i][j] = Math.min(dist[i][j], Math.max(dist[i][k], dist[k][j]));
                }
            }
        }

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            if (dist[s][e] == Integer.MAX_VALUE) {
                System.out.println(-1);
            } else {
                System.out.println(dist[s][e]);
            }
        }
    }
}

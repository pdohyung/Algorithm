import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    static int T, N, M;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    void solution() throws IOException {
        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            Queue<int[]> q = new LinkedList<>();
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int num = 0;
            int cnt = 0;
            boolean flag = true;

            for (int j = 0; j < N; j++) {
                num = Integer.parseInt(st.nextToken());
                q.add(new int[]{j, num});
            }

            while (!q.isEmpty()) {
                flag = true;
                int[] first = q.poll();

                for (int[] cur : q) {
                    if (cur[1] > first[1]) {
                        flag = false;
                        break;
                    }
                }

                if (flag) {
                    cnt++;
                    if (first[0] == M) {
                        break;
                    }
                } else {
                    q.add(first);
                }
            }
            System.out.println(cnt);
        }
    }
}
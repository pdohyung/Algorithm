import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    void solution() throws IOException {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        boolean[] visit = new boolean[N + 1];
        int cnt = 0;

        for (int i = 2; i <= N; i++) {
            for (int j = i; j <= N; j += i) {
                if (!visit[j]) {
                    cnt++;
                    visit[j] = true;
                }

                if (cnt == K) {
                    System.out.println(j);
                    return;
                }
            }
        }
    }

}
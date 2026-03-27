import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        if (N == 0) {
            System.out.println(0);
            return;
        }

        st = new StringTokenizer(br.readLine());
        Queue<Integer> q = new ArrayDeque<>();

        for (int i = 0; i < N; i++) q.offer(Integer.parseInt(st.nextToken()));

        int cnt = 0;
        int now = 0;

        while (!q.isEmpty()) {
            int w = q.poll();

            if (now + w > M) {
                cnt++;
                now = w;
            } else {
                now += w;
            }
        }

        if (now > 0) cnt++;

        System.out.println(cnt);
    }
}

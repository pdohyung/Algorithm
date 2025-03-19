import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Queue<Long> q = new ArrayDeque<>();
        for (long i = 0; i <= 9; i++) q.add(i);
        int cnt = -1;

        while (!q.isEmpty()) {
            long now = q.poll();
            long mod = now % 10;
            cnt++;

            if (cnt == N) {
                System.out.println(now);
                return;
            }

            for (long i = 0; i < mod; i++) q.add(now * 10 + i);
        }

        System.out.println(-1);
    }
}

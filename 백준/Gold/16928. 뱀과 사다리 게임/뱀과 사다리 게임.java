import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static int N, M;
    static boolean[] visit;
    static int[] cnt;
    static HashMap<Integer, Integer> events;

    public static void main(String[] args) throws IOException {

        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visit = new boolean[101];
        cnt = new int[101];
        events = new HashMap<>();

        for (int i = 0; i < N + M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            events.put(s, e);
        }

        bfs();
        System.out.println(cnt[100]);
    }

    static void bfs() {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.add(1);
        cnt[1] = 0;
        visit[1] = true;

        while (!queue.isEmpty()) {
            int nx = queue.poll();

            if (nx == 100) return;

            for (int i = 1; i <= 6; i++) {
                int next = nx + i;

                if (next > 100) continue;

                if (events.containsKey(next)) {
                    next = events.get(next);
                }

                if (!visit[next]) {
                    visit[next] = true;
                    cnt[next] = cnt[nx] + 1;
                    queue.add(next);
                }
            }
        }
    }
}

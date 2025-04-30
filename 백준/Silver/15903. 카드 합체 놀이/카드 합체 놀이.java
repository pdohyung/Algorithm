import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) pq.offer(Long.parseLong(st.nextToken()));

        for (int i = 0; i < m; i++) {
            long o1 = pq.poll();
            long o2 = pq.poll();
            long sum = o1 + o2;
            pq.offer(sum);
            pq.offer(sum);
        }

        long result = 0;

        while (!pq.isEmpty()) {
            result += pq.poll();
        }

        System.out.println(result);
    }
}

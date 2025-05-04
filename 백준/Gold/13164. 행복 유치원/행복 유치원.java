import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] heights = new int[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) heights[i] = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0; i < N - 1; i++) pq.offer(heights[i + 1] - heights[i]);
        for (int i = 0; i < K - 1; i++) pq.poll();
        int result = 0;

        while (!pq.isEmpty()) {
            result += pq.poll();
        }

        System.out.println(result);
    }
}

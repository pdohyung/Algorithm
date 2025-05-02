import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0; i < N; i++) pq.add(Integer.parseInt(br.readLine()));
        int answer = 0;

        while (pq.size() >= 3) {
            answer += pq.poll() + pq.poll();
            pq.poll();
        }

        while (!pq.isEmpty()) {
            answer += pq.poll();
        }

        System.out.println(answer);
    }
}

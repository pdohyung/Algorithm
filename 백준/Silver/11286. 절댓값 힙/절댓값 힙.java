
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            int absCompare = Integer.compare(Math.abs(a), Math.abs(b));
            return absCompare != 0 ? absCompare : Integer.compare(a, b);
        });
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());

//            System.out.println(pq);

            if (num == 0) {
                if (pq.isEmpty()) {
                    answer.append("0").append("\n");
                } else {
                    answer.append(pq.poll()).append("\n");
                }
            } else {
                pq.add(num);
            }
        }

        System.out.println(answer);
    }
}

import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    static int res;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    void solution() throws IOException {
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pqNegative = new PriorityQueue<>(Comparator.naturalOrder());
        PriorityQueue<Integer> pqPositive = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());

            if (num <= 0) {
                pqNegative.add(num);
                continue;
            }
            pqPositive.add(num);
        }

        calculatePQ(pqNegative);
        calculatePQ(pqPositive);

        System.out.println(res);
    }

    private void calculatePQ(PriorityQueue<Integer> pq) {
        while (pq.size() > 1) {
            int num1 = pq.remove();
            int num2 = pq.remove();
            int add = num1 + num2;
            int multi = num1 * num2;

            if (add < multi) {
                res += multi;
                continue;
            }
            res += add;
        }

        if (!pq.isEmpty()) {
            res += pq.remove();
        }
    }
}
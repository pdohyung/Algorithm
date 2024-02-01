import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    static int[] budget;
    static int N;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    void solution() throws IOException {
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int max = Integer.parseInt(br.readLine());
        int sum = 0;
        int low = 1;
        int high = 0;
        budget = new int[N];

        for (int i = 0; i < N; i++) {
            budget[i] = Integer.parseInt(st.nextToken());
            sum += budget[i];
            high = Math.max(high, budget[i]);
        }

        if (sum <= max) {
            System.out.println(high);
            return;
        }

        while (low < high - 1) {
            int mid = (low + high) / 2;

            if (find(mid) > max) {
                high = mid;
            } else {
                low = mid;
            }
        }
        System.out.println(low);
    }

    private int find(int standard) {
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += Math.min(standard, budget[i]);
        }
        return sum;
    }
}
import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    void solution() throws IOException {
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int res = 0;
        int cnt = 0;

        for (int i = 0; i < N; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }

        while (pq.size() > 1) {
            int bundle1 = pq.remove();
            int bundle2 = pq.remove();
            cnt = bundle1 + bundle2;
            res += cnt;
            pq.add(cnt);
        }

        System.out.println(res);
    }
}
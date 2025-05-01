
import java.util.*;
import java.io.*;

class Box {
    int from, to, cost;

    public Box(int from, int to, int cost) {
        this.from = from;
        this.to = to;
        this.cost = cost;
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(br.readLine());

        List<Box> boxes = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            boxes.add(new Box(s, e, c));
        }

        boxes.sort((a, b) -> {
            if (a.to != b.to) return Integer.compare(a.to, b.to);
            return Integer.compare(a.from, b.from);
        });

        int[] out = new int[N + 1];
        Arrays.fill(out, C);
        int result = 0;

        for (Box b : boxes) {
            int from = b.from;
            int to = b.to;
            int cost = b.cost;

            int now = Integer.MAX_VALUE;

            for (int i = from; i < to; i++) {
                now = Math.min(now, out[i]);
            }

            for (int i = from; i < to; i++) {
                out[i] -= Math.min(now, cost);
            }

            result += Math.min(now, cost);
        }

        System.out.println(result);
    }
}

import java.util.*;
import java.io.*;

class Flower {
    int start, end;

    public Flower(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Flower> flowers = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int sM = Integer.parseInt(st.nextToken());
            int sD = Integer.parseInt(st.nextToken());
            int eM = Integer.parseInt(st.nextToken());
            int eD = Integer.parseInt(st.nextToken());

            flowers.add(new Flower(cal(sM, sD), cal(eM, eD)));
        }

        flowers.sort((a, b) -> {
            if (a.start != b.start) return Integer.compare(a.start, b.start);
            else return Integer.compare(b.end, a.end);
        });

        int now = cal(3, 1);
        int maxEnd = 0;
        int cnt = 0;
        int idx = 0;

        while (now < 335) {
            boolean find = false;

            while (idx < flowers.size() && flowers.get(idx).start <= now) {
                maxEnd = Math.max(maxEnd, flowers.get(idx).end);
                idx++;
                find = true;
            }

            if (!find) {
                System.out.println(0);
                return;
            }

            now = maxEnd;
            cnt++;
        }

        System.out.println(cnt);
    }

    public static int cal(int m, int d) {
        int total = 0;

        for (int i = 1; i < m; i++) {
            if (i == 2) total += 28;
            else if (i == 4 || i == 6 || i == 9 || i == 11) total += 30;
            else total += 31;
        }

        return total + d;
    }
}

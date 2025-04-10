import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] bars = new int[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            bars[i][0] = Integer.parseInt(st.nextToken());
            bars[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(bars, (a, b) -> Integer.compare(a[0], b[0]));

        int maxH = 0;
        int maxIdx = 0;
        int sum = 0;

        for (int i = 0; i < N; i++) {
            if (maxH < bars[i][1]) {
                maxH = bars[i][1];
                maxIdx = i;
            }
        }

        int l = bars[0][0];
        int h = bars[0][1];
        for (int i = 0; i <= maxIdx; i++) {
            if (bars[i][1] >= h) {
                sum += h * (bars[i][0] - l);
                h = bars[i][1];
                l = bars[i][0];
            }
        }

        l = bars[N - 1][0];
        h = bars[N - 1][1];
        for (int i = N - 1; i >= maxIdx; i--) {
            if (bars[i][1] >= h) {
                sum += h * (l - bars[i][0]);
                h = bars[i][1];
                l = bars[i][0];
            }
        }

        System.out.println(sum + maxH);
    }
}

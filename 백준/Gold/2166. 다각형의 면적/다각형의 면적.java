
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] x = new int[N];
        int[] y = new int[N];
        long sum1 = 0;
        long sum2 = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            if (i == N - 1) {
                sum1 += (long) x[i] * y[0];
                sum2 += (long) y[i] * x[0];
            } else {
                sum1 += (long) x[i] * y[i + 1];
                sum2 += (long) y[i] * x[i + 1];
            }
        }

        double answer = Math.abs(sum1 - sum2) * 0.5;

        System.out.printf("%.1f\n", answer);
    }
}

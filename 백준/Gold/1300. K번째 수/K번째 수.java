
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());
        long k = Long.parseLong(br.readLine());

        long start = 1;
        long end = N * N;

        while (start <= end) {
            long mid = (start + end) / 2;
            long cnt = 0;

            for (int i = 1; i <= N; i++) {
                cnt += Math.min(mid / i, N);
            }

            if (cnt >= k) {
                end = mid - 1;
            }  else {
                start = mid + 1;
            }
        }

        System.out.println(start);
    }
}

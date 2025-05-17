
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        // N개의 랜선을 만들어야 함, 자르고 나머지 길이는 버림, N개 보다 많이 만드는 것도 포함, 최대 랜선 길이
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        long[] lines = new long[K];

        for (int i = 0; i < K; i++) {
            lines[i] = Long.parseLong(br.readLine());
        }

        long start = 1;
        long end = Integer.MAX_VALUE;

        while (start <= end) {
            long mid = (start + end) / 2;
            long cnt = 0;

            for (int i = 0; i < K; i++) {
                cnt += lines[i] / mid;
            }

            if (cnt >= N) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        System.out.println(end);
    }
}

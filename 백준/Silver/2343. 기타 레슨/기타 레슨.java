
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] A = new int[N];
        int start = 0;
        int end = 0;

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
            end += A[i];
            start = Math.max(start, A[i]);
        }

        while (start <= end) {
            int mid = (start + end) / 2;
            int cnt = 0;
            int sum = 0;

            for (int i = 0; i < N; i++) {
                if (sum + A[i] > mid) {
                    sum = 0;
                    cnt++;
                }

                sum += A[i];
            }

            if (sum > 0) cnt++;

            if (cnt <= M) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        System.out.println(start);
    }
}


import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int[] h = new int[N];

        for (int i = 0; i < N; i++) {
            h[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(h);

        int start = 1;
        int end = h[N - 1] - h[0];

        while (start <= end) {
            int mid = (start + end) / 2;
            int cnt = 1;
            int before = 0;

            for (int i = 1; i < N; i++) {
                if (h[i] - h[before] >= mid) {
                    cnt++;
                    before = i;
                }
            }

            if (cnt >= C) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        System.out.println(end);
    }
}

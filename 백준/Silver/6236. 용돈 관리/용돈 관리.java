import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] A = new int[N];
        int max = 0;
        int high = 0;

        for (int i = 0; i < N; i++) {
            int money = Integer.parseInt(br.readLine());
            A[i] = money;
            high += money;
            max = Math.max(max, A[i]);
        }

        int low = max;

        while (low < high) {
            int mid = (low + high) / 2;
            int cnt = 0;
            int sum = 0;

            for (int i = 0; i < N; i++) {
                if (sum + A[i] > mid) {
                    sum = A[i];
                    cnt++;
                } else {
                    sum += A[i];
                }
            }

            if (cnt >= M) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        System.out.println(low);
    }
}

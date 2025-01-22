
import java.util.*;
import java.io.*;

public class Main {

    static int N, M;
    static int[] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[N];
        int start = 0;
        int end = 0;

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
            start = Math.max(start, A[i]);
            end += A[i];
        }

        while (start <= end) {
            int mid = (start + end) / 2;

            int cnt = getCnt(mid);

            if (cnt > M) start = mid + 1;
            else end = mid - 1;
        }

        System.out.println(start);
    }

    private static int getCnt(int mid) {
        int sum = 0;
        int cnt = 0;

        for (int i = 0; i < N; i++) {
            if (sum + A[i] > mid) {
                sum = 0;
                cnt++;
            }
            sum += A[i];
        }

        if (sum != 0) cnt++;

        return cnt;
    }
}


import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] A = new int[N + 1];
        int[] sum = new int[N + 1];

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
            sum[i] = sum[i - 1] + A[i];
        }

        int start = 0;
        int end = 1;
        int min = Integer.MAX_VALUE;

        while (start < end) {
            int result = sum[end] - sum[start];
//            System.out.println(start + " " + end + " " + result);
            if (result >= S) {
                min = Math.min(min, end - start);
                start++;
            } else {
                if (end == N) {
                    start++;
                } else {
                    end++;
                }
            }
        }
//        System.out.println(Arrays.toString(sum));
        if (min == Integer.MAX_VALUE) {
            System.out.println(0);
        } else {
            System.out.println(min);
        }
    }
}

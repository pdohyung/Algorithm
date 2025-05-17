
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        // 각 지방한테 가능한 한 최대의 예산을 지급
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] C = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        int start = 1;
        int end = 0;

        for (int i = 0; i < N; i++) {
            C[i] = Integer.parseInt(st.nextToken());
            end = Math.max(end, C[i]);
        }

        int M = Integer.parseInt(br.readLine());

        while (start <= end) {
            int mid = (start + end) / 2;
            int cost = 0;

            for (int i = 0; i < N; i++) {
                if (C[i] < mid) {
                    cost += C[i];
                } else {
                    cost += mid;
                }
            }

            if (cost <= M) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        System.out.println(end);
    }
}

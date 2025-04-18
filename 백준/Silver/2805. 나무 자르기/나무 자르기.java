
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 적어도 M미터의 나무를 가져가기 위해 설정할 수 있는 높이의 최댓값
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] trees = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) trees[i] = Integer.parseInt(st.nextToken());

        int start = 0;
        int end = 1_000_000_000;

        while (start <= end) {
            int mid = (start + end) / 2;
            long sum = 0;

            for (int i = 0; i < trees.length; i++) {
                if (trees[i] > mid) sum += trees[i] - mid;
            }

            if (sum >= M) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        System.out.println(end);
    }
}

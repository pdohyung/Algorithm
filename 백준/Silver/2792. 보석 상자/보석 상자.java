import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        // M가지 보석, N명의 학생, 보석을 받지 못하는 학생이 있어도 됨, 학생은 항상 같은 보석만 가짐
        // 질투심 가장 많이 보석을 가져간 수
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] count = new int[M];

        for (int i = 0; i < M; i++) {
            count[i] = Integer.parseInt(br.readLine());
        }

        int start = 1;
        int end = 1_000_000_000;

        while (start <= end) {
            int mid = (start + end) / 2;
            int cnt = 0;

            for (int c : count) {
                cnt += c / mid;
                if (c % mid > 0) cnt++;
            }

            if (cnt <= N) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        System.out.println(start);
    }
}

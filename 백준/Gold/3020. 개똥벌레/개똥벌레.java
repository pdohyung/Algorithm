
import java.util.*;
import java.io.*;

public class Main {

    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[] hurdle1 = new int[N / 2 + 1];
        int[] hurdle2 = new int[N / 2 + 1];

        for (int i = 0; i < N / 2; i++) {
            hurdle1[i] = Integer.parseInt(br.readLine());
            hurdle2[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(hurdle1);
        Arrays.sort(hurdle2);
        int[] result = new int[M + 1];
        int min = Integer.MAX_VALUE;
        int answer = 0;

        for (int i = 1; i <= M; i++) {
//            System.out.println(bs(hurdle1, i) + " " + bs(hurdle2, M + 1 - i));
            result[i] = bs(hurdle1, i) + bs(hurdle2, M + 1 - i);
            min = Math.min(min, result[i]);
        }

        for (int i = 1; i <= M; i++) {
            if (result[i] == min) answer++;
        }

        System.out.println(min + " " + answer);
    }

    // 해당 높이에서 이분 탐색
    private static int bs(int[] hurdle, int height) {
        int start = 0;
        int end = hurdle.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (hurdle[mid] >= height) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return hurdle.length - start;
    }
}

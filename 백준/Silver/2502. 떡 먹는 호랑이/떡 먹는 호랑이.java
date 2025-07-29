import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // 할머니가 무사히 넘어온 D째 날에 준 떡의 개수가 K개
        // 첫날에 준 떡 개수 A, 그 다음날에 준 떡의 개수 B를 계산
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int D = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] a = new int[D + 1];
        int[] b = new int[D + 1];

        a[1] = 1;
        a[2] = 0;
        b[1] = 0;
        b[2] = 1;

        for (int i = 3; i <= D; i++) {
            a[i] = a[i - 1] + a[i - 2];
            b[i] = b[i - 1] + b[i - 2];
        }

        int first = 0;
        int second = 0;

        for (int i = 1;; i++) {
            int res = K - a[D] * i;

            if (res % b[D] == 0) {
                first = i;
                second = res / b[D];
                break;
            }
        }

        System.out.println(first + "\n" + second);
    }
}

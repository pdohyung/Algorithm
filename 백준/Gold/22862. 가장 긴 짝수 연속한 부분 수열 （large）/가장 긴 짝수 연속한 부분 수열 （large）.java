import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] S = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) S[i] = Integer.parseInt(st.nextToken());

        int left = 0;
        int right = 0;
        int cnt = 0;
        int max = 0;

        while (right < N) {
            if (S[right] % 2 == 0) {
                max = Math.max(max, right - left - cnt + 1);
            } else {
                cnt++;
            }

            while (cnt > K) {
                if (S[left++] % 2 != 0) cnt--;
            }

            right++;
        }

        System.out.println(max);
    }
}

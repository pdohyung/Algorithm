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
        int cnt = S[left] % 2 == 0 ? 0 : 1;
        int max = S[left] % 2 == 0 ? 1 : 0;

        while (left < N - 1) {
            if (cnt > K) {
                if (left < right) {
                    if (S[left++] % 2 != 0) cnt--;
                } else {
                    if (S[++right] % 2 != 0) cnt++;
                }
            } else {
                max = Math.max(max, right - left + 1 - cnt);

                if (right < N - 1) {
                    if (S[++right] % 2 != 0) cnt++;
                } else {
                    if (S[left++] % 2 != 0) cnt--;
                }
            }

        }

        System.out.println(max);
    }
}

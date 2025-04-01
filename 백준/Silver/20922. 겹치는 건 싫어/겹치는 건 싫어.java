
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] a = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) a[i] = Integer.parseInt(st.nextToken());

        int start = 0;
        int end = 0;
        int answer = 0;
        int[] cnt = new int[100_001];

        while (end < a.length) {
            while (end < a.length && cnt[a[end]] + 1 <= K) {
                cnt[a[end]]++;
                end++;
            }

            answer = Math.max(answer, end - start);
            cnt[a[start]]--;
            start++;
        }

        System.out.println(answer);
    }

}

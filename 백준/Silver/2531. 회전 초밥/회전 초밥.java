import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] belt = new int[N];
        int[] cnt = new int[d + 1];

        for (int i = 0; i < N; i++) {
            belt[i] = Integer.parseInt(br.readLine());
        }

        int kind = 0;
        int answer = 0;

        for (int i = 0; i < k; i++) {
            if (cnt[belt[i]] == 0) kind++;
            cnt[belt[i]]++;
        }

        for (int i = 0; i < N; i++) {
            int max = cnt[c] == 0 ? kind + 1 : kind;
            answer = Math.max(answer, max);

            if (--cnt[belt[i]] == 0) kind--;

            int next = belt[(i + k) % belt.length];
            if (cnt[next]++ == 0) kind++;
        }

        System.out.println(answer);
    }
}

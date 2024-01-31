import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    static int[] visitInfo;
    static int[] S;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    void solution() throws IOException {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        visitInfo = new int[N + 1];
        S = new int[N + 1];
        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            visitInfo[i] = Integer.parseInt(st.nextToken());
        }

        S[1] = visitInfo[1];

        for (int i = 2; i <= N; i++) {
            S[i] = S[i - 1] + visitInfo[i];
        }

        int start = 0;
        int end = X;
        int sum = 0;
        int max = 0;
        int cnt = 1;

        while (end <= N) {
            sum = S[end] - S[start];
            start++;
            end++;
            if (max > sum) {
                continue;
            }
            if (max == sum) {
                cnt++;
                continue;
            }
            max = Math.max(max, sum);
            cnt = 1;
        }
        if (max == 0) {
            System.out.println("SAD");
            return;
        }
        System.out.println(max);
        System.out.println(cnt);
    }
}

import java.util.*;
import java.io.*;

public class Main {

    static int N, answer;
    static int[] S, W;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        S = new int[N];
        W = new int[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            S[i] = Integer.parseInt(st.nextToken());
            W[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0);

        System.out.println(answer);
    }

    private static void dfs(int start, int cnt) {
        if (start >= N) return;

//        System.out.println(start + " " + cnt);
//        System.out.println(Arrays.toString(S));
//        System.out.println(Arrays.toString(W));
//        System.out.println();

        for (int i = 0; i < N; i++) {
            if (start == i) continue;
            if (S[start] <= 0 || S[i] <= 0) {
                dfs(start + 1, cnt);
                continue;
            }

            int nextCnt = cnt;
            int temp1 = S[i];
            int temp2 = S[start];

            S[i] -= W[start];
            S[start] -= W[i];

            if (S[i] <= 0) nextCnt++;
            if (S[start] <= 0) nextCnt++;
            answer = Math.max(answer, nextCnt);

            dfs(start + 1, nextCnt);

            S[i] = temp1;
            S[start] = temp2;
        }
    }
}

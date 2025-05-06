import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        char[][] chars = new char[N][M];

        for (int i = 0; i < N; i++) chars[i] = br.readLine().toCharArray();

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < M; i++) {
            int[] cnt = new int[26];
            int max = 0;
            int idx = 0;

            for (int j = 0; j < N; j++) {
                int now = chars[j][i] - 65;
                cnt[now]++;
                max = Math.max(max, cnt[now]);
            }

            for (int j = 0; j < 26; j++) {
                if (cnt[j] == max) {
                    idx = j;
                    break;
                }
            }

            result.append(Character.toChars(idx + 65));
        }

        int cnt = 0;

        for (int i = 0; i < N; i++) {
            int now = 0;

            for (int j = 0; j < M; j++) {
                if (chars[i][j] != result.charAt(j)) now++;
            }

            cnt += now;
        }

        System.out.println(result);
        System.out.println(cnt);
    }
}

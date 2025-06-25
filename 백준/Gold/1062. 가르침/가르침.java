
import java.util.*;
import java.io.*;

public class Main {

    static int N, K, cnt, max;
    static List<String> words;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        words = new ArrayList<>();
        cnt = 0;
        max = 0;

        if (K < 5) {
            System.out.println(max);
            return;
        }

        visited = new boolean[26];
        visited['a' - 'a'] = true;
        visited['c' - 'a'] = true;
        visited['i' - 'a'] = true;
        visited['n' - 'a'] = true;
        visited['t' - 'a'] = true;

        for (int i = 0; i < N; i++) {
            String now = br.readLine();
            now = now.replaceAll("anta", "");
            now = now.replaceAll("tica", "");
            words.add(now);
        }

        dfs(0, 0);

        System.out.println(max + cnt);
    }

    private static void dfs(int depth, int idx) {
        if (depth == K - 5) {
            int now = 0;

            for (String word : words) {
                if (canRead(word)) now++;
            }

            max = Math.max(max, now);
            return;
        }

        for (int i = idx; i < 26; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            dfs(depth + 1, i + 1);
            visited[i] = false;
        }
    }

    private static boolean canRead(String word) {
        for (char c : word.toCharArray()) {
            if (!visited[c - 'a']) return false;
        }
        return true;
    }
}

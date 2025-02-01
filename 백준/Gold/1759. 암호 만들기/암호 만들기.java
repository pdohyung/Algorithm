import java.util.*;
import java.io.*;

public class Main {
    static int L, C;
    static char[] A;
    static StringBuilder answer = new StringBuilder();
    static List<Character> vowels = List.of('a', 'e', 'i', 'o', 'u');

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        A = new char[C];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            A[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(A);

        dfs(new StringBuilder(), 0, 0, 0);

        System.out.println(answer);
    }

    private static void dfs(StringBuilder result, int idx, int cnt1, int cnt2) {
        if (result.length() == L) {
            if (cnt1 >= 1 && cnt2 >= 2) {
                answer.append(result).append("\n");
            }
            return;
        }

        for (int i = idx; i < C; i++) {
            result.append(A[i]);

            if (vowels.contains(A[i])) {
                dfs(result, i + 1, cnt1 + 1, cnt2);
            } else {
                dfs(result, i + 1, cnt1, cnt2 + 1);
            }

            result.deleteCharAt(result.length() - 1);
        }
    }
}

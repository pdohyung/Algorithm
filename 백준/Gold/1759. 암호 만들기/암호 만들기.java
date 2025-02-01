
import java.util.*;
import java.io.*;

public class Main {

    static int L, C;
    static StringBuilder answer;
    static char[] A;
    static boolean[] visited;
    static List<Character> vowels = List.of('a', 'e', 'i', 'o', 'u');

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        A = new char[C];
        visited = new boolean[C];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < C; i++) {
            A[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(A);

        answer = new StringBuilder();
        dfs(new StringBuilder(), 0, 0, 0);

        System.out.println(answer);
    }

    private static void dfs(StringBuilder now, int idx, int cnt1, int cnt2) {
        if (now.length() == L && cnt1 >= 1 && cnt2 >= 2) {
            answer.append(now).append("\n");
            return;
        }

        for (int i = idx; i < A.length; i++) {
            if (!visited[i]) {
                StringBuilder next = new StringBuilder(now);
                int newCnt1 = cnt1;
                int newCnt2 = cnt2;
                next.append(A[i]);

                if (vowels.contains(A[i])) {
                    newCnt1++;
                } else {
                    newCnt2++;
                }

                visited[i] = true;
                dfs(next, i, newCnt1, newCnt2);
                visited[i] = false;
            }
        }
    }
}

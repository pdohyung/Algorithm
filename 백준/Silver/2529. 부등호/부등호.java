
import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static long min, max;
    static char[] A;
    static boolean[] visited;
    static StringBuilder minAnswer, maxAnswer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        A = new char[N + 1];
        visited = new boolean[10];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            A[i] = st.nextToken().charAt(0);
        }

        min = Long.MAX_VALUE;
        max = Long.MIN_VALUE;

        for (int i = 0; i <= 9; i++) {
            visited[i] = true;
            dfs(0, i, new StringBuilder().append(i));
            visited = new boolean[10];
        }

        System.out.println(maxAnswer);
        System.out.println(minAnswer);
    }

    private static void dfs(int depth, int before, StringBuilder result) {
        if (depth == N) {
            long num = Long.parseLong(result.toString());

            if (min > num) {
                min = num;
                minAnswer = new StringBuilder(result);
            }

            if (max < num) {
                max = num;
                maxAnswer = new StringBuilder(result);
            }
//            System.out.println(result);
            return;
        }

        for (int i = 0; i <= 9; i++) {
//            System.out.println(depth + " " + i);
            if (!visited[i] && isValid(A[depth], before, i)) {
                visited[i] = true;
                StringBuilder next = new StringBuilder(result);
                dfs(depth + 1, i, next.append(i));
                visited[i] = false;
            }
        }
    }

    private static boolean isValid(char c, int a, int b) {
//        System.out.println(c + " " + a + " " + b);
        if (c == '<') {
            return a < b;
        } else {
            return a > b;
        }
    }
}

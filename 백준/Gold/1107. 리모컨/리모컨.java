
import java.util.*;
import java.io.*;

public class Main {

    static ArrayList<Integer> impossible;
    static int N, M, min, length, answerLength, depth;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        length = 1;
        int n = N;
        while (n > 0) {
            length++;
            n = n / 10;
        }

        impossible = new ArrayList<>();
        if (M != 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                impossible.add(Integer.parseInt(st.nextToken()));
            }
        }

        if (N == 100) {
            System.out.println(0);
            return;
        }

        min = Integer.MAX_VALUE;

        for (int i = length - 2; i <= length; i++) {
            depth = i;
            if (depth <= 0) continue;
            dfs(new StringBuilder());
        }

        if (min == Integer.MAX_VALUE) {
            System.out.println(Math.abs(100 - N));
        } else {
            System.out.println(Math.min(Math.abs(100 - N), min + answerLength));
        }
    }

    private static void dfs(StringBuilder result) {
        if (depth == result.length()) {
            int now = Integer.parseInt(result.toString());
            if (min > Math.abs(N - now)) {
                answerLength = result.length();
                min = Math.abs(N - now);
//                System.out.println(answerLength + " " + min);
            }
            return;
        }

        for (int i = 0; i <= 9; i++) {
            if (!impossible.contains(i)) {
                dfs(result.append(i));
                result.deleteCharAt(result.length() - 1);
            }
        }
    }
}
